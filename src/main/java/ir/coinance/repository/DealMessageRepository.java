package ir.coinance.repository;

import ir.coinance.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealMessageRepository extends JpaRepository<Bank, Long> {
}
