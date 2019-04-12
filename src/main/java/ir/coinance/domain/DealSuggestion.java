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
public class DealSuggestion extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private Float differencePrice;

    @NotNull
    @Column(nullable = false)
    private Integer rangeFrom;

    @NotNull
    @Column(nullable = false)
    private Integer rangeTo;

    @ManyToOne
    private EnumType type;

    @ManyToOne
    private EnumType status;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private User user;
}
