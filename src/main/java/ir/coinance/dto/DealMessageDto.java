package ir.coinance.dto;

import lombok.Data;

@Data
public class DealMessageDto extends BaseDto {
    private String description;
    private byte[] attachment;
    private Long dealRequestId;
    private UserDto user;
}
