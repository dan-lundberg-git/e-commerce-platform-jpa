package git.lundberg.dan.ecommerce.domain.dto;

public record AddressResponseDto(
        Long id,
        String street,
        String city,
        String zipCode
) {
}
