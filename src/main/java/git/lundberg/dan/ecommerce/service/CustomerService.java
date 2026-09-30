package git.lundberg.dan.ecommerce.service;

import git.lundberg.dan.ecommerce.domain.dto.CustomerRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CustomerResponseDto;
import git.lundberg.dan.ecommerce.exception.EmailAlreadyExistsException;

public interface CustomerService {

    CustomerResponseDto register(CustomerRequestDto customerRequestDto) throws EmailAlreadyExistsException;

    CustomerResponseDto findById(Long id);

    CustomerResponseDto update(Long id, CustomerRequestDto customerRequestDto);
}
