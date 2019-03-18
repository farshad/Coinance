package ir.coinance.dto;

import lombok.Data;

@Data
public class BankAccountDto extends BaseDto {

    private String shaba;
    private String cardNo;
    private BankDto bank;
    private Long userId;
}
