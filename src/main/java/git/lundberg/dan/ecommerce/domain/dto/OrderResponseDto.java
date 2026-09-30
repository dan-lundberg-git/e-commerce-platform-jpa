package git.lundberg.dan.ecommerce.domain.dto;

import git.lundberg.dan.ecommerce.domain.entity.OrderStatus;

import java.time.Instant;
import java.util.List;

public record OrderResponseDto(
        Long id,
        Instant orderDate,
        OrderStatus status,
        Long customerId,
        List<OrderItemResponseDto> items
) {
}
