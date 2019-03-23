package ir.coinance.dto;

import lombok.Data;

@Data
public class SettlementRequestDto extends BaseDto {
    private Float amount;
    private UserDto user;
    private EnumTypeDto status;
}
