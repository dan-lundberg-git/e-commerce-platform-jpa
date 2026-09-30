package git.lundberg.dan.ecommerce.mapper;

import git.lundberg.dan.ecommerce.domain.dto.AddressResponseDto;
import git.lundberg.dan.ecommerce.domain.dto.CustomerRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CustomerResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.Address;
import git.lundberg.dan.ecommerce.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponseDto toResponse(Customer customer) {
        Address address = customer.getAddress();

        return new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName() + " " + customer.getLastName(),
                customer.getEmail(),
                new AddressResponseDto(
                        address.getId(),
                        address.getStreet(),
                        address.getCity(),
                        address.getZipCode()
                )
        );
    }

    public Customer toEntity(CustomerRequestDto request) {
        Customer customer = new Customer();
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setAddress(new Address(
                request.street(),
                request.city(),
                request.zipCode()
        ));
        return customer;
    }
}
