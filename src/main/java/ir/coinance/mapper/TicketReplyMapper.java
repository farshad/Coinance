package ir.coinance.mapper;

import ir.coinance.domain.TicketReply;
import ir.coinance.dto.TicketReplyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class})
public interface TicketReplyMapper extends BaseMapper<TicketReply, TicketReplyDto> {
}
