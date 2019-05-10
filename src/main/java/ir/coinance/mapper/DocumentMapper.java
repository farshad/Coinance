package ir.coinance.mapper;

import ir.coinance.domain.Document;
import ir.coinance.dto.DocumentDto;
import ir.coinance.dto.DocumentExceptUserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnumTypeMapper.class})
public interface DocumentMapper extends BaseMapper<Document, DocumentDto> {
    DocumentExceptUserDto toExceptUserDto(Document e);
    List<DocumentExceptUserDto> toExceptUserDtos(List<Document> e);
}
