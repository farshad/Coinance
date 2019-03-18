package ir.coinance.dto;

import lombok.Data;

@Data
public class TicketDto extends BaseDto {
    private String title;
    private String description;
    private EnumTypeDto unit;
    private EnumTypeDto status;
    private UserDto user;
}
