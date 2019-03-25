package ir.coinance.service;

import ir.coinance.dto.AllEnumTypesDto;
import ir.coinance.dto.EnumTypeDto;
import ir.coinance.mapper.EnumTypeMapper;
import ir.coinance.repository.EnumTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class EnumTypeService {

    @Autowired
    private EnumTypeRepository repository;

    @Autowired
    private EnumTypeMapper mapper;

    @Transactional(readOnly = true)
    public AllEnumTypesDto fetchEnumTypes(){
        AllEnumTypesDto allEnumTypesDto = new AllEnumTypesDto();

        List<EnumTypeDto> enumTypeDtos = mapper.toDtos(repository.findByParentIdIsNull());
        Supplier<Stream<EnumTypeDto>> stream = () -> enumTypeDtos.stream();

        allEnumTypesDto.setDocumentTypeStatus(stream.get().filter(et -> et.getKey().equals("document_type_status")).findAny().orElse(null));
        allEnumTypesDto.setFileType(stream.get().filter(et -> et.getKey().equals("file_type")).findAny().orElse(null));
        allEnumTypesDto.setTicketReplyStatus(stream.get().filter(et -> et.getKey().equals("ticket_reply_status")).findAny().orElse(null));
        allEnumTypesDto.setTicketStatus(stream.get().filter(et -> et.getKey().equals("ticket_status")).findAny().orElse(null));
        allEnumTypesDto.setUnitType(stream.get().filter(et -> et.getKey().equals("unit_type")).findAny().orElse(null));
        allEnumTypesDto.setDealSuggestionType(stream.get().filter(et -> et.getKey().equals("deal_suggestion_type")).findAny().orElse(null));
        allEnumTypesDto.setDealSuggestionStatus(stream.get().filter(et -> et.getKey().equals("deal_suggestion_status")).findAny().orElse(null));

        return allEnumTypesDto;
    }
}
