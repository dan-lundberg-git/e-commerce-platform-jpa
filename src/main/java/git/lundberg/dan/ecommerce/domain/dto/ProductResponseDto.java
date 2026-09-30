package git.lundberg.dan.ecommerce.domain.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDto(
        Long id,
        String name,
        BigDecimal price,
        List<String> imageUrls,
        String categoryName
) {
}
