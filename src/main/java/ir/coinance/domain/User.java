package ir.coinance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "users")
@SequenceGenerator(name = "user_seq")
@Data
public class User extends BaseEntity {

    @NotNull
    @Size(min = 13, max = 13)
    @Column(length = 30, unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 8, max = 255)
    @Column(name = "password_hash", nullable = false)
    @JsonIgnore
    private String password;

    @Size(max = 200)
    @Column(length = 200)
    private String fullName;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @NotNull
    @Size(min = 13, max = 13)
    @Column(length = 30)
    private String mobile;

    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    @NotNull
    @Column(nullable = false)
    private boolean verified = false;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<BankAccount> bankAccounts;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;
}
