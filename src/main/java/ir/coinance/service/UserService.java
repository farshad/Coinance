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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Boolean changePassword(String password){
        User user = securityUtils.getCurrentUser();
        user.setPassword(passwordEncoder.encode(password));
        repository.save(user);

        return true;
    }

    @Transactional
    public UserDto updateProfile(UserUpdateDto dto){
        User user = securityUtils.getCurrentUser();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());

        return mapper.toDto(repository.save(user));
    }
}
