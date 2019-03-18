package ir.coinance.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto extends BaseDto {
    private Float amount;
    private String description;
    private Date payDate;
    private EnumTypeDto status;
    private Long userId;
}
