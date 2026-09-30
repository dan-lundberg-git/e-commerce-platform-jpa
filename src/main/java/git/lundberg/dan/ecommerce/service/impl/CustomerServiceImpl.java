package git.lundberg.dan.ecommerce.service.impl;

import git.lundberg.dan.ecommerce.domain.dto.CustomerRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CustomerResponseDto;
import git.lundberg.dan.ecommerce.mapper.CustomerMapper;
import git.lundberg.dan.ecommerce.repository.CustomerRepository;
import git.lundberg.dan.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public CustomerResponseDto register(CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public CustomerResponseDto findById(Long id) {
        return null;
    }

    @Override
    public CustomerResponseDto update(Long id, CustomerRequestDto customerRequestDto) {
        return null;
    }
}
