package ir.coinance.dto;

import lombok.Data;

@Data
public class SettlementRequestDto extends BaseDto {
    private Float amount;
    private Long userId;
    private EnumTypeDto status;
}
