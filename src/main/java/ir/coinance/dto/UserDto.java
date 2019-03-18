package ir.coinance.dto;

import lombok.Data;

@Data
public class UserDto extends BaseDto {
    private String login;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private boolean activated = false;
    private boolean verified = false;
    private String imageUrl;
}
