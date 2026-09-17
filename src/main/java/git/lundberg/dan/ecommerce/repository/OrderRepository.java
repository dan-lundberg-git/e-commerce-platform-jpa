package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // TODO:
    //  Required Queries
    //      - Find all orders belonging to a specific customer ID.
    //      - Find orders by status and use a strategy to avoid the N+1 problem (loading order items in the same query).
    //  Optional / Advanced Queries
    //      - Find orders created after a specific date.
    //      - Find orders created between two dates.
    //      - Find orders that contain a specific product.
    //      - Count orders by status.
    //      - Find orders by customer ID and status.
    //  Clarification (N+1)
    //      For the “find by status” query, use one of the following approaches:
    //      - @EntityGraph to load items in the same query, or
    //      - JOIN FETCH in JPQL.
}
