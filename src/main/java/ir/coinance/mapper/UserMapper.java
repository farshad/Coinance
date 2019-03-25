package ir.coinance.mapper;

import ir.coinance.domain.User;
import ir.coinance.dto.UserDto;
import ir.coinance.dto.UserInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BankAccountMapper.class})
public interface UserMapper extends BaseMapper<User, UserDto> {
    UserInfoDto toUserInfoDto(User e);
}
