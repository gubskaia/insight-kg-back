package kg.iuca.InsightKgBackendApplication.repositories;

import kg.iuca.InsightKgBackendApplication.entities.Initiative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitiativeRepository extends JpaRepository<Initiative, Long> {
    Page<Initiative> findAll(Pageable pageable);
}