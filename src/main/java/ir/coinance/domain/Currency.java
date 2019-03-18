package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "currency_seq")
@Data
public class Currency extends BaseEntity {

    @NotNull
    @Column(name = "english_name", nullable = false)
    private String englishName;

    @NotNull
    @Column(name = "persian_name", nullable = false)
    private String persianName;

    private String symbol;
    private Float price;
}
