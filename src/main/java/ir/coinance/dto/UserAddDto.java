package ir.coinance.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserAddDto {

    @NotNull
    @Size(min = 11, max = 11, message = "{mobile.length}")
    private String mobile;

    @NotNull
    private String password;

    @Email
    private String email;

    @NotNull
    private String fullName;
}
