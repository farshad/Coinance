package ir.coinance.mapper;

import ir.coinance.domain.SettlementRequest;
import ir.coinance.dto.SettlementRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class})
public interface SettlementRequestMapper extends BaseMapper<SettlementRequest, SettlementRequestDto> {
}
