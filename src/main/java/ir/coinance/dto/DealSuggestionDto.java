package ir.coinance.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class DealSuggestionDto extends BaseDto {

    private Float differencePrice;
    @Column(nullable = false)
    private Integer rangeFrom;
    private Integer rangeTo;
    private EnumTypeDto type;
    private EnumTypeDto status;
    private CurrencyDto currency;
    private UserDto user;
}
