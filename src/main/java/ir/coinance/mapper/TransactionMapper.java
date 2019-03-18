package ir.coinance.mapper;

import ir.coinance.domain.Transaction;
import ir.coinance.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class})
public interface TransactionMapper extends BaseMapper<Transaction, TransactionDto> {
}
