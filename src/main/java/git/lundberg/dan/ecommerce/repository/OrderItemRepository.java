package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // This repository is optional because OrderItem is typically managed through
    // Order using cascading and orphan removal.
    // TODO:
    //  Optional / Advanced Queries
    //      - Find all order items belonging to a specific order ID.
    //      - Find all order items for a specific product ID.
    //      - Find order items where quantity is greater than a given value.
}
