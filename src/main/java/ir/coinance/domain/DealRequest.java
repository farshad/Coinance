package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "deal_request_seq")
@Data
public class DealRequest extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private Float amount;

    @NotNull
    @Column(nullable = false)
    private Float pawnerAmount;

    @ManyToOne
    private EnumType status;

    @ManyToOne
    private EnumType releaseMoney;

    @ManyToOne
    private User user;

    private Long dealSuggestionId;
}
