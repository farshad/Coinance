package ir.coinance.repository;

import ir.coinance.domain.SettlementRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRequestRepository extends JpaRepository<SettlementRequest, Long> {
}
