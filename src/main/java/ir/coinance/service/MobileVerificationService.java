package ir.coinance.service;

import ir.coinance.config.security.exception.CustomException;
import ir.coinance.domain.MobileVerification;
import ir.coinance.repository.MobileVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MobileVerificationService {

    @Autowired
    private MobileVerificationRepository repository;

    private String generate(){
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    @Transactional
    public String getVerificationCode(String mobileNumber){
        String verificationCode = generate();
        while (repository.existsMobileVerificationByVerificationCodeAndMobileNumber(verificationCode, mobileNumber)){
            verificationCode = generate();
        }
        repository.save(MobileVerification.builder()
                .mobileNumber(mobileNumber)
                .verificationCode(verificationCode)
                .build());

        return verificationCode;
    }

    @Transactional(readOnly = true)
    public Boolean waitingCheck(String mobileNumber){
        Boolean result = false;
        MobileVerification mobileVerification = repository.findByMobileNumberAndAndCreatedDateGreaterThanEqual(mobileNumber, Instant.now().minusSeconds(120));
        if (mobileVerification != null){
            result = true;
        }

        return result;
    }

    @Transactional
    public Boolean verify(String mobileNumber, String verificationCode) throws CustomException {
        AtomicReference<Boolean> result = new AtomicReference<>(false);
        Optional<MobileVerification> mobileVerification = repository.findByMobileNumberAndVerificationCode(mobileNumber, verificationCode);

        mobileVerification.ifPresent(mv -> {
            mv.setVerified(true);
            repository.save(mv);
            result.set(true);
        });

        if (!result.get()){
            throw new CustomException("کد وارد شده صحیح نمی باشد.");
        }

        return result.get();
    }
}
