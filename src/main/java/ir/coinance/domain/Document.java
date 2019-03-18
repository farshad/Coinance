package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "document_seq")
@Data
public class Document extends BaseEntity {

    @NotNull
    @Column(name = "image_file", nullable = false)
    private Byte[] image;

    @ManyToOne
    private EnumType fileType;

    private Long userId;
}
