package ir.coinance.repository;

import ir.coinance.domain.DealSuggestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealSuggestionRepository extends JpaRepository<DealSuggestion, Long> {
    Page<DealSuggestion> findByUserId(Long userId, Pageable pageable);
    Page<DealSuggestion> findByTypeIdOrderByCreatedDateDesc(Long typeId, Pageable pageable);
    DealSuggestion findByIdAndUserId(Long id, Long userId);
}
