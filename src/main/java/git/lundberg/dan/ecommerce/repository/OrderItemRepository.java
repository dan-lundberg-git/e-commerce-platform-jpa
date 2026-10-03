package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
