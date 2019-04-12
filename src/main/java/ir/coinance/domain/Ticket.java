package ir.coinance.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Builder
public class Ticket extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false, length = 1000)
    private String description;

    @ManyToOne
    private EnumType unit;

    @ManyToOne
    private EnumType status;

    @ManyToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<TicketReply> ticketReplies;
}
