package ir.coinance.repository;

import ir.coinance.domain.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnumTypeRepository extends JpaRepository<EnumType, Long> {
}
