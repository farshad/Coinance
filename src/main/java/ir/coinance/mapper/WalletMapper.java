package ir.coinance.mapper;

import ir.coinance.domain.Wallet;
import ir.coinance.dto.WalletDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper extends BaseMapper<Wallet, WalletDto> {
}
