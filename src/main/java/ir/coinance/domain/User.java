package ir.coinance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "users")
@SequenceGenerator(name = "user_seq")
@Data
public class User extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 8, max = 255)
    @Column(name = "password_hash", nullable = false)
    private String password;

    @Size(max = 200)
    @Column(name = "first_name", length = 200)
    private String fullName;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @Size(min = 11, max = 11)
    @Column(length = 30)
    private String phone;

    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    @NotNull
    @Column(nullable = false)
    private boolean verified = false;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;
}
