package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // TODO:
    //  Required Queries
    //      - Find products by their category name.
    //      - Find products within a specific price range.
    //  Optional / Advanced Queries
    //      - Find products whose name contains a given keyword.
    //      - Find products cheaper than a given price.
    //      - Find products ordered by price (ascending or descending).
    //      - Count how many products exist in a specific category.
    //      - Find products by category ID.

    List<Product> findByCategoryName(String categoryName);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
