package ir.coinance.dto;

import lombok.Data;

@Data
public class UserDto extends BaseDto {
    private String login;
    private String fullName;
    private String email;
    private String mobile;
    private boolean activated = false;
    private boolean verified = false;
    private String imageUrl;
}
