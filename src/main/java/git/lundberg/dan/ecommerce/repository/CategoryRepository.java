package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // TODO:
    //  Required Queries
    //      - Find a category by name (case-insensitive).
    //      - Check if a category exists by name.
    //  Optional / Advanced Queries
    //      - Find categories whose name contains a given keyword.
    //      - Count how many categories exist.
}
