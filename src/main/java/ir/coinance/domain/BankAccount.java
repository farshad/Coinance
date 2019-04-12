package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "sequenceGenerator")
@Data
public class BankAccount extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String shaba;

    @NotNull
    @Column(name = "card_no", nullable = false)
    private String cardNo;

    @ManyToOne
    private Bank bank;

    @Column(name = "user_id")
    private Long userId;
}
