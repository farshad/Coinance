package ir.coinance.mapper;

import ir.coinance.domain.User;
import ir.coinance.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {
}
