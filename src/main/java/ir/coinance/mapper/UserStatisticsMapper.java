package ir.coinance.mapper;

import ir.coinance.domain.UserStatistics;
import ir.coinance.dto.UserStatisticsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserStatisticsMapper extends BaseMapper<UserStatistics, UserStatisticsDto> {
}
