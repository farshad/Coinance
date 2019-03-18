package ir.coinance.service;

import ir.coinance.domain.MobileVerification;
import ir.coinance.repository.MobileVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class MobileVerificationService {

    @Autowired
    private MobileVerificationRepository repository;

    public String generate(){
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    @Transactional
    public String getVerficationCode(){
        String verificationCode = generate();
        while (repository.existsMobileVerificationByVerificationCodeAndMobileNumber(verificationCode, "12345678987")){
            verificationCode = generate();
        }
        repository.save(MobileVerification.builder()
                .mobileNumber("12345678987")
                .verificationCode(verificationCode)
                .build());

        return verificationCode;
    }
}
