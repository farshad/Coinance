package ir.coinance.mapper;

import ir.coinance.domain.Bank;
import ir.coinance.dto.BankDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper extends BaseMapper<Bank, BankDto> {
}
