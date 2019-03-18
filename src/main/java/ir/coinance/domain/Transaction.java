package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "transactions")
@SequenceGenerator(name = "transaction_seq")
@Data
public class Transaction extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private Float amount;

    @Column(length = 1000)
    private String description;

    private Date payDate;

    @ManyToOne
    private EnumType status;

    private Long userId;
}
