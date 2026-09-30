package git.lundberg.dan.ecommerce.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDto(
        @NotBlank(message = "First name cannot be blank or null")
        String firstName,

        @NotBlank(message = "Last name cannot be blank or null")
        String lastName,

        @NotBlank(message = "Email cannot be blank or null")
        @Email(message = "This is not a valid email address")
        String email,

        @NotBlank(message = "Street cannot be blank or null")
        String street,

        @NotBlank(message = "City cannot be blank or null")
        String city,

        @NotBlank(message = "Zip Code cannot be blank or null")
        String zipCode
) {
}
