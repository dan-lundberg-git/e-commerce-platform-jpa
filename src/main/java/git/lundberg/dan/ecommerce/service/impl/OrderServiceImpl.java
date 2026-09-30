package git.lundberg.dan.ecommerce.service.impl;

import git.lundberg.dan.ecommerce.domain.dto.OrderRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.OrderResponseDto;
import git.lundberg.dan.ecommerce.mapper.OrderMapper;
import git.lundberg.dan.ecommerce.repository.CustomerRepository;
import git.lundberg.dan.ecommerce.repository.OrderRepository;
import git.lundberg.dan.ecommerce.repository.ProductRepository;
import git.lundberg.dan.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(
            OrderRepository orderRepository,
            CustomerRepository customerRepository,
            ProductRepository productRepository,
            OrderMapper orderMapper
    ) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        return null;
    }
}
