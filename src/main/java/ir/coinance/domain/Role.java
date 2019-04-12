package ir.coinance.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "sequenceGenerator")
@Getter@Setter
public class Role extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}
