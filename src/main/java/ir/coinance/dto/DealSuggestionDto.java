package ir.coinance.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DealSuggestionDto extends BaseDto {

    @NotNull
    private Float differencePrice;
    @NotNull
    private Integer rangeFrom;
    @NotNull
    private Integer rangeTo;
    private EnumTypeDto type;
    private EnumTypeDto status;
    private CurrencyDto currency;
    private UserInfoDto user;
}
