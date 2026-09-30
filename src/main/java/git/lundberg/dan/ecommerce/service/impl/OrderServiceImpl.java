package git.lundberg.dan.ecommerce.service.impl;

import git.lundberg.dan.ecommerce.domain.dto.OrderItemRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.OrderRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.OrderResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.Customer;
import git.lundberg.dan.ecommerce.domain.entity.Order;
import git.lundberg.dan.ecommerce.domain.entity.Product;
import git.lundberg.dan.ecommerce.exception.ResourceNotFoundException;
import git.lundberg.dan.ecommerce.mapper.OrderMapper;
import git.lundberg.dan.ecommerce.repository.CustomerRepository;
import git.lundberg.dan.ecommerce.repository.OrderRepository;
import git.lundberg.dan.ecommerce.repository.ProductRepository;
import git.lundberg.dan.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    @Transactional
    public OrderResponseDto placeOrder(OrderRequestDto request) {
        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found: " + request.customerId()));

        List<Long> productIds = request.items().stream()
                .map(OrderItemRequestDto::productId)
                .distinct()
                .toList();

        Map<Long, Product> productsById = productRepository.findAllById(productIds).stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        Order order = orderMapper.toEntity(
                request,
                customer,
                productId -> Optional.ofNullable(productsById.get(productId))
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Product not found: " + productId))
        );

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }
}
