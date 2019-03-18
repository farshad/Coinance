package ir.coinance.repository;

import ir.coinance.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String username);
    User findOneWithAuthoritiesByLogin(String username);
}
