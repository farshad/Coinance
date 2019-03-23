package ir.coinance.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdateDto {

    @NotNull
    private MultipartFile image;

    @Email
    private String email;

    @NotNull
    private String fullName;
}
