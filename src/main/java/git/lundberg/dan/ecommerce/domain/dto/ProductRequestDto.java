package git.lundberg.dan.ecommerce.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank(message = "Name cannot be blank or null")
        String name,

        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price must be a positive number")
        BigDecimal price,

        @NotNull(message = "Category Id cannot be null")
        @Positive(message = "Category Id must be a positive number")
        Long categoryId
) {
}
