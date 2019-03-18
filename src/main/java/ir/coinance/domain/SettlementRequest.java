package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "settlement_request_seq")
@Data
public class SettlementRequest extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private Float amount;

    private Long userId;

    @ManyToOne
    private EnumType status;
}
