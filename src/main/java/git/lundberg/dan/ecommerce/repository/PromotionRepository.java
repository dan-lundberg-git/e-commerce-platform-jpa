package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
