package ir.coinance.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "sequenceGenerator")
@Data
public class EnumType extends BaseEntity {

    private String name;
    private String key;

    @Column(name = "parent_id")
    private Long parentId;

    @OneToMany
    @JoinColumn(name = "parent_id")
    private List<EnumType> children;
}
