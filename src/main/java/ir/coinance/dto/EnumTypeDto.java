package ir.coinance.dto;

import lombok.Data;

import java.util.List;

@Data
public class EnumTypeDto extends BaseDto {
    private String name;
    private String key;
    private Long parentId;
    private List<EnumTypeDto> children;
}
