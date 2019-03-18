package ir.coinance.repository;

import ir.coinance.domain.DealSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealSuggestionRepository extends JpaRepository<DealSuggestion, Long> {
}
