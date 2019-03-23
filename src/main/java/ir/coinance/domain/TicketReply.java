package ir.coinance.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "ticket_reply_seq")
@Data
public class TicketReply extends BaseEntity {

    @NotNull
    @Column(nullable = false, length = 1000)
    private String description;

    @Column(name = "ticket_id")
    private Long ticketId;
}
