package ir.coinance.mapper;

import ir.coinance.domain.DealMessage;
import ir.coinance.dto.DealMessageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface DealMessageMapper extends BaseMapper<DealMessage, DealMessageDto> {
}
