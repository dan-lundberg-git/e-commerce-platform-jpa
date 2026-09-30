package git.lundberg.dan.ecommerce.service.impl;

import git.lundberg.dan.ecommerce.domain.dto.CustomerRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CustomerResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.Customer;
import git.lundberg.dan.ecommerce.exception.EmailAlreadyExistsException;
import git.lundberg.dan.ecommerce.exception.ResourceNotFoundException;
import git.lundberg.dan.ecommerce.mapper.CustomerMapper;
import git.lundberg.dan.ecommerce.repository.CustomerRepository;
import git.lundberg.dan.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    @Transactional
    public CustomerResponseDto register(CustomerRequestDto request) {
        if (customerRepository.findByEmailIgnoreCase(request.email()).isPresent()) {
            throw new EmailAlreadyExistsException(request.email());
        }

        Customer customer = customerRepository.save(customerMapper.toEntity(request));
        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponseDto findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional
    public CustomerResponseDto update(Long id, CustomerRequestDto request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));

        customerRepository.findByEmailIgnoreCase(request.email())
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> {
                    throw new EmailAlreadyExistsException(request.email());
                });

        customerMapper.updateEntity(customer, request);
        return customerMapper.toResponse(customer);
    }
}
