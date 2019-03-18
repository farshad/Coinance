package ir.coinance.repository;

import ir.coinance.domain.DealRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRequestRepository extends JpaRepository<DealRequest, Long> {
}
