package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
@Data
public class DealMessage extends BaseEntity {

    @NotNull
    @Column(length = 1000, nullable = false)
    private String description;

    private byte[] attachment;

    private Long dealRequestId;

    @ManyToOne
    private User user;
}
