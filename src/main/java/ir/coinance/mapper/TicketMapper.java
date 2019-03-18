package ir.coinance.mapper;

import ir.coinance.domain.Ticket;
import ir.coinance.dto.TicketDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class, UserMapper.class})
public interface TicketMapper extends BaseMapper<Ticket, TicketDto> {
}
