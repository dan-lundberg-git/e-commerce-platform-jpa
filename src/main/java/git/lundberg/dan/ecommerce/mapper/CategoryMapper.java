package git.lundberg.dan.ecommerce.mapper;

import git.lundberg.dan.ecommerce.domain.dto.CategoryResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponseDto toResponse(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }
}
