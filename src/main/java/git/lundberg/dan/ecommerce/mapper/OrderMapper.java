package git.lundberg.dan.ecommerce.mapper;

import git.lundberg.dan.ecommerce.domain.dto.OrderItemResponseDto;
import git.lundberg.dan.ecommerce.domain.dto.OrderRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.OrderResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class OrderMapper {
    public OrderResponseDto toResponse(Order order) {
        List<OrderItemResponseDto> items = order.getOrderItems().stream()
                .map(item -> new OrderItemResponseDto(
                        item.getId(),
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getPriceAtPurchase()
                ))
                .toList();

        return new OrderResponseDto(
                order.getId(),
                order.getOrderDate(),
                order.getOrderStatus(),
                order.getCustomer().getId(),
                items
        );
    }

    public Order toEntity(
            OrderRequestDto request,
            Customer customer,
            Function<Long, Product> productLookup
    ) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderStatus(OrderStatus.CREATED);

        List<OrderItem> items = request.items().stream()
                .map(itemRequest -> {
                    Product product = productLookup.apply(itemRequest.productId());

                    OrderItem item = new OrderItem();
                    item.setOrder(order);
                    item.setProduct(product);
                    item.setQuantity(itemRequest.quantity());
                    item.setPriceAtPurchase(product.getPrice());
                    return item;
                })
                .toList();

        order.setOrderItems(items);
        return order;
    }
}
