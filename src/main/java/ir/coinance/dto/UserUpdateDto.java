package ir.coinance.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdateDto {

    @Email
    private String email;

    @NotNull
    private String fullName;
}
