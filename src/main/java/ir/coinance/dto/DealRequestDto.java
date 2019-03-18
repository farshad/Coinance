package ir.coinance.dto;

import lombok.Data;

@Data
public class DealRequestDto extends BaseDto {

    private Float amount;
    private Float pawnerAmount;
    private EnumTypeDto status;
    private EnumTypeDto releaseMoney;
    private UserDto user;
    private Long dealSuggestionId;
}
