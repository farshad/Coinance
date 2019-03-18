package ir.coinance.dto;

import lombok.Data;

@Data
public class DocumentDto extends BaseDto {
    private Byte[] image;
    private EnumTypeDto fileType;
    private Long userId;
}
