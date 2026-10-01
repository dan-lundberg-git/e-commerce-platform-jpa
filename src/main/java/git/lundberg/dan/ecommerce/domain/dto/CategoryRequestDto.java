package git.lundberg.dan.ecommerce.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDto(
        @NotBlank(message = "Name cannot be blank or null")
        String name
) {
}
