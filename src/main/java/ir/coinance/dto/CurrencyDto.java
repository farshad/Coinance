package ir.coinance.dto;

import lombok.Data;

@Data
public class CurrencyDto extends BaseDto {
    private String englishName;
    private String persianName;
    private String symbol;
    private Float price;
}
