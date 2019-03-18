package ir.coinance.mapper;

import ir.coinance.domain.BankAccount;
import ir.coinance.dto.BankAccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BankMapper.class})
public interface BankAccountMapper extends BaseMapper<BankAccount, BankAccountDto> {
}
