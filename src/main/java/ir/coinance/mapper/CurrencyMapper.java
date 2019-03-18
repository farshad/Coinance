package ir.coinance.mapper;

import ir.coinance.domain.Currency;
import ir.coinance.dto.CurrencyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapper extends BaseMapper<Currency, CurrencyDto> {
}
