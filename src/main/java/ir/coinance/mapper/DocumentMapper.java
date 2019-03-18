package ir.coinance.mapper;

import ir.coinance.domain.Document;
import ir.coinance.dto.DocumentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class})
public interface DocumentMapper extends BaseMapper<Document, DocumentDto> {
}
