package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByNameIgnoreCase(String name);

    // Took the liberty to ignore case sensitivity here too
    boolean existsByNameIgnoreCase(String name);
}
