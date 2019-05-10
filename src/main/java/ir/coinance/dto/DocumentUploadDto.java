package ir.coinance.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocumentUploadDto {
    private List<DocumentAddDto> documentAddDtos;
}
