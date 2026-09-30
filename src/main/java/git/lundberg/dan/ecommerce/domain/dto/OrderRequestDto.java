package git.lundberg.dan.ecommerce.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record OrderRequestDto(
        @NotNull(message = "Customer Id cannot be null")
        @Positive(message = "Customer Id must be a positive number")
        Long customerId,

        @NotEmpty(message = "An Order must contain at least one Order Item")
        List<@Valid OrderItemRequestDto> items
) {
}
