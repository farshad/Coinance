package ir.coinance.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private String fullName;
    private boolean activated;
    private boolean verified;
    private String imageUrl;
}
