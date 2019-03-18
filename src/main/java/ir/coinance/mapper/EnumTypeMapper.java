package ir.coinance.mapper;

import ir.coinance.domain.EnumType;
import ir.coinance.dto.EnumTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnumTypeMapper extends BaseMapper<EnumType, EnumTypeDto> {
}
