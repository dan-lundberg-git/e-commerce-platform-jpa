package git.lundberg.dan.ecommerce.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank(message = "Name cannot be blank or null")
        String name,

        @NotBlank(message = "Price cannot be blank or null")
        BigDecimal price,

        @NotBlank(message = "Category Id cannot be blank or null")
        Long categoryId
) {
}
