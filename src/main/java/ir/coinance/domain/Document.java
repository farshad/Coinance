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
public class Document extends BaseEntity {

    @NotNull
    @Column(name = "image_file", nullable = false)
    private byte[] image;

    private String name;
    private String suffix;

    @ManyToOne
    private EnumType fileType;

    @ManyToOne
    private EnumType status;

    @ManyToOne
    private User user;
}
