package ir.coinance.repository;

import ir.coinance.domain.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnumTypeRepository extends JpaRepository<EnumType, Long> {
    EnumType findByKey(String key);
    List<EnumType> findByParentIdIsNull();
}
