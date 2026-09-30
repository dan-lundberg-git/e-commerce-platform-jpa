package git.lundberg.dan.ecommerce.service;

import git.lundberg.dan.ecommerce.domain.dto.OrderRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.OrderResponseDto;

public interface OrderService {

    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);
}
