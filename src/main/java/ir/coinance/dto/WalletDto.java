package ir.coinance.dto;

import lombok.Data;

@Data
public class WalletDto extends BaseDto {
    private Float amount;
    private Long userId;
}
