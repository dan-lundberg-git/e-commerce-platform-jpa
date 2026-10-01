package git.lundberg.dan.ecommerce.service;

import git.lundberg.dan.ecommerce.domain.dto.CategoryRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto create(CategoryRequestDto request);

    List<CategoryResponseDto> findAll();
}
