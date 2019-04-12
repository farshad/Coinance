package ir.coinance.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "sequenceGenerator")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Builder
public class SettlementRequest extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private Float amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private EnumType status;
}
