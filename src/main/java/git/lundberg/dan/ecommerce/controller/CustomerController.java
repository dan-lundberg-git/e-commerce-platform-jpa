package git.lundberg.dan.ecommerce.controller;

import git.lundberg.dan.ecommerce.domain.dto.CustomerRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CustomerResponseDto;
import git.lundberg.dan.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(
            @Valid
            @RequestBody
            CustomerRequestDto request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.register(request));
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getById(
            @PathVariable
            Long id
    ) {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto update(
            @PathVariable
            Long id,

            @Valid
            @RequestBody
            CustomerRequestDto request
    ) {
        return customerService.update(id, request);
    }
}
