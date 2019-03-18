package ir.coinance.repository;

import ir.coinance.domain.MobileVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface MobileVerificationRepository extends JpaRepository<MobileVerification, Long> {
    Boolean existsMobileVerificationByVerificationCodeAndMobileNumber(String verificationCode, String mobileNumber);
    Boolean existsMobileVerificationByMobileNumberAndVerified(String mobileNumber, Boolean verified);
    Optional<MobileVerification> findByMobileNumberAndVerificationCode(String verificationCode, String mobileNumber);
    MobileVerification findByMobileNumberAndAndCreatedDateGreaterThanEqual(String mobileNumber, Instant now);
}
