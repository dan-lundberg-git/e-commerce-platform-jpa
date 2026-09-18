package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    // TODO:
    //  Required Queries
    //      - Find promotions that are active on a given date.
    //  Optional / Advanced Queries
    //      - Find promotions by code.
    //      - Find promotions starting after a given date.
    //      - Find promotions ending before a given date.
    //      - Find promotions that have no end date.
    //      - Find promotions active today.

    // Have to use JPQL here, because the derived method name becomes insanely long.
    @Query("SELECT p FROM Promotion p WHERE p.startDate <= :date AND p.endDate >= :date")
    List<Promotion> findActivePromotionsOnDate(@Param("date") LocalDate date);
}
