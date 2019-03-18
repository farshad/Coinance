package ir.coinance.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "mobile_verification_seq")
@Builder
@Data
public class MobileVerification extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String verificationCode;

    @NotNull
    @Size(min = 11, max = 11)
    @Column(length = 30)
    private String mobileNumber;

    private Boolean verified = false;
}
