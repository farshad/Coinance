package ir.coinance.dto;

import lombok.Data;

@Data
public class DocumentExceptUserDto extends BaseDto {
    private byte[] image;
    private String suffix;
    private EnumTypeDto fileType;
    private EnumTypeDto status;
}
