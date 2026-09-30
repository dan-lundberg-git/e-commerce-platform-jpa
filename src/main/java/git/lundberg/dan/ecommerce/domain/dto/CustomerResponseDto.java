package git.lundberg.dan.ecommerce.domain.dto;

public record CustomerResponseDto(
        Long id,
        String fullName,
        String email,
        AddressResponseDto addressResponse
) {
}
