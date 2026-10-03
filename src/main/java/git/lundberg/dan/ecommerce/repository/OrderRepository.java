package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.domain.entity.Order;
import git.lundberg.dan.ecommerce.domain.entity.OrderStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
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
