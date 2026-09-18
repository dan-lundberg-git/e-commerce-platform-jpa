package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.Order;
import git.lundberg.dan.ecommerce.utils.OrderStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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

    List<Order> findByCustomer_Id(Long customerId);

    @EntityGraph(attributePaths = "orderItems")
    List<Order> findDistinctByOrderStatus(OrderStatus orderStatus);

    // What's really happening with @EntityGraph above:
    // SELECT o.*, oi.*
    // FROM orders o
    // LEFT JOIN order_items oi ON oi.order_id = o.id
    // WHERE o.status = ?

    // Not sure if I want to use @EntityGraph, since there's too much "magic" happening.
    // A direct approach with full control would be like below, and probably more to my liking.
    // @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.orderItems WHERE o.orderStatus = :status")
    // List<Order> findByOrderStatusWithItems(@Param("status") OrderStatus status);
}
