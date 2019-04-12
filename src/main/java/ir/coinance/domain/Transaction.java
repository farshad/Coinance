package ir.coinance.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "transactions")
@SequenceGenerator(name = "sequenceGenerator")
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

