package ir.coinance.dto;

import lombok.Data;

@Data
public class AllEnumTypesDto {
    private EnumTypeDto unitType;
    private EnumTypeDto ticketStatus;
    private EnumTypeDto ticketReplyStatus;
    private EnumTypeDto documentTypeStatus;
    private EnumTypeDto fileType;
    private EnumTypeDto dealSuggestionType;
    private EnumTypeDto dealSuggestionStatus;
}
