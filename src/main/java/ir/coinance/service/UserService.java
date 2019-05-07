package ir.coinance.service;

import ir.coinance.config.security.JwtTokenProvider;
import ir.coinance.config.security.SecurityUtils;
import ir.coinance.config.security.exception.CustomException;
import ir.coinance.domain.Role;
import ir.coinance.domain.User;
import ir.coinance.dto.UserAddDto;
import ir.coinance.dto.UserDto;
import ir.coinance.dto.UserUpdateDto;
import ir.coinance.dto.enums.RoleEnum;
import ir.coinance.mapper.UserMapper;
import ir.coinance.repository.MobileVerificationRepository;
import ir.coinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MobileVerificationRepository mobileVerificationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    @Value("${profile.image.upload.dir}")
    private String profileImageUploadDir;

    @Transactional
    public String register(UserAddDto dto) throws CustomException {
        if (!mobileVerificationRepository.existsMobileVerificationByMobileNumberAndVerified(dto.getMobile(), true)){
            throw new CustomException("شماره موبایل شما تایید نشده است");
        }

        User entity = new User();
        entity.setLogin(dto.getMobile());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setMobile(dto.getMobile());
        entity.setEmail(dto.getEmail());
        entity.setFullName(dto.getFullName());
        entity.setActivated(true);
        entity.setRoles(List.of(new Role(RoleEnum.ROLE_USER.getAuthority())));
        User user = repository.save(entity);

        return jwtTokenProvider.createToken(entity.getLogin(), user.getRoles());
    }

    @Transactional
    public Boolean changePassword(String oldPassword, String newPassword){
        User user = securityUtils.getCurrentUser();
        if (!passwordEncoder.matches(oldPassword, user.getPassword())){
            throw new CustomException("رمز عبور جاری اشتباه است");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        repository.save(user);

        return true;
    }

    @Transactional
    public UserDto updateProfile(UserUpdateDto dto){
        User user = securityUtils.getCurrentUser();
        if (dto.getImage() != null){
            String imageUrl = profileImageUploadDir + user.getId() + System.currentTimeMillis() + "_" + dto.getImage().getOriginalFilename();
            user.setImageUrl(imageUrl);
            try {
                byte[] bytes = dto.getImage().getBytes();
                Path path = Paths.get(imageUrl);
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());

        return mapper.toDto(repository.save(user));
    }

    @Transactional(readOnly = true)
    public UserDto current(){
        return mapper.toDto(securityUtils.getCurrentUser());
    }
}
