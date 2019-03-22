package ir.coinance.dto;

import lombok.Data;

@Data
public class TicketAddDto {
    private String title;
    private String description;
    private Long unitId;
}
