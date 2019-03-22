package ir.coinance.config.security;

import ir.coinance.domain.User;
import ir.coinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Utility class for Spring Security.
 */
@Component
public final class SecurityUtils {

    @Autowired
    private UserRepository userRepository;

    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = null;
        User user = null;

        if (securityContext != null){
            if (securityContext.getAuthentication().getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) securityContext.getAuthentication().getPrincipal();
                username = springSecurityUser.getUsername();
            } else if (securityContext.getAuthentication().getPrincipal() instanceof String) {
                username = (String) securityContext.getAuthentication().getPrincipal();
            }
            user = userRepository.findByLogin(username);
        }

        return user;
    }

    /**
     * Get the JWT of the current user.
     *
     * @return the JWT of the current user
     */
    public Optional<String> getCurrentUserJWT() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
            .filter(authentication -> authentication.getCredentials() instanceof String)
            .map(authentication -> (String) authentication.getCredentials());
    }

    /**
     * Check if a user is authenticated.
     *
     * @return true if the user is authenticated, false otherwise
     */
    public boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
            .map(authentication -> authentication.getAuthorities().stream()
                .noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER")))
            .orElse(false);
    }

    /**
     * If the current user has a specific authority (security role).
     * <p>
     * The name of this method comes from the isUserInRole() method in the Servlet API
     *
     * @param authority the authority to check
     * @return true if the current user has the authority, false otherwise
     */
    public boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
            .map(authentication -> authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
            .orElse(false);
    }
}
