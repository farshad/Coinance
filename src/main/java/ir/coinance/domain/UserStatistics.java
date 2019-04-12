package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "sequenceGenerator")
@Data
public class UserStatistics extends BaseEntity {

    private Integer saleSuggestion;
    private Integer purchaseSuggestion;
    private Integer successfulDeals;
    private Long userId;
}
