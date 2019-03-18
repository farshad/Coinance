package ir.coinance.dto;

import lombok.Data;

@Data
public class TicketReplyDto extends BaseDto {
    private String description;
    private EnumTypeDto status;
    private Long ticketId;
}
