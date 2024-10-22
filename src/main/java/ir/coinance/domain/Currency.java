package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
@Data
public class Currency extends BaseEntity {

    @NotNull
    @Column(name = "english_name")
    private String englishName;

    @NotNull
    @Column(name = "persian_name", nullable = false)
    private String persianName;

    private String symbol;
    private Float price;
}
