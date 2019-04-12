package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
@Data
public class Bank extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String name;
}
