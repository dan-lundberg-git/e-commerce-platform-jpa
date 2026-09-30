package git.lundberg.dan.ecommerce.service;

import git.lundberg.dan.ecommerce.domain.dto.CustomerRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto register(CustomerRequestDto customerRequestDto);

    CustomerResponseDto findById(Long id);

    CustomerResponseDto update(Long id, CustomerRequestDto customerRequestDto);
}
