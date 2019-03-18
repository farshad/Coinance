package ir.coinance.repository;

import ir.coinance.domain.MobileVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileVerificationRepository extends JpaRepository<MobileVerification, Long> {
    Boolean existsMobileVerificationByVerificationCodeAndMobileNumber(String verificationCode, String mobileNumber);
}
