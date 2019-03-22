package ir.coinance.service;

import ir.coinance.config.security.JwtTokenProvider;
import ir.coinance.config.security.exception.CustomException;
import ir.coinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByLogin(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("نام " +
                    "کاربری یا رمز عبور اشتباه است", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
