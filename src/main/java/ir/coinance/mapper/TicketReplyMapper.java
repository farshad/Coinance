package ir.coinance.mapper;

import ir.coinance.domain.DealRequest;
import ir.coinance.dto.DealRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class})
public interface TicketReplyMapper extends BaseMapper<DealRequest, DealRequestDto> {
}
