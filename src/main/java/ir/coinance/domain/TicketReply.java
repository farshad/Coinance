package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "ticket_reply_seq")
@Data
public class TicketReply extends BaseEntity {

    @NotNull
    @Column(nullable = false, length = 1000)
    private String description;

    @ManyToOne
    private EnumType status;

    private Long ticketId;
}
