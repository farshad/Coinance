package ir.coinance.mapper;

import ir.coinance.domain.DealSuggestion;
import ir.coinance.dto.DealSuggestionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class, CurrencyMapper.class, UserMapper.class})
public interface DealSuggestionMapper extends BaseMapper<DealSuggestion, DealSuggestionDto> {
}
