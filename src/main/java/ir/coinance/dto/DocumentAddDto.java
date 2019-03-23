package ir.coinance.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class DocumentAddDto {
    @NotNull
    private MultipartFile image;
    @NotNull
    private Long fileTypeId;
}
