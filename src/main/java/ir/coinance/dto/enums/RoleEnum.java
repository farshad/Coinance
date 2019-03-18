package ir.coinance.dto.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
  ROLE_ADMIN, ROLE_USER;

  public String getAuthority() {
    return name();
  }

}
