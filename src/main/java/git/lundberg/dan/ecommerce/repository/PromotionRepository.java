package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.domain.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    // Have to use JPQL here, because the derived method name becomes insanely long.
    @Query("SELECT p FROM Promotion p WHERE p.startDate <= :date AND p.endDate >= :date")
    List<Promotion> findActivePromotionsOnDate(@Param("date") LocalDate date);
}
