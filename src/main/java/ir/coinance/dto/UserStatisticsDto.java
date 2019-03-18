package ir.coinance.dto;

import lombok.Data;

@Data
public class UserStatisticsDto extends BaseDto {
    private Integer saleSuggestion;
    private Integer purchaseSuggestion;
    private Integer successfulDeals;
    private Long userId;
}
