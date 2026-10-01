package git.lundberg.dan.ecommerce.service.impl;

import git.lundberg.dan.ecommerce.domain.dto.CategoryRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CategoryResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.Category;
import git.lundberg.dan.ecommerce.mapper.CategoryMapper;
import git.lundberg.dan.ecommerce.repository.CategoryRepository;
import git.lundberg.dan.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional
    public CategoryResponseDto create(CategoryRequestDto request) {
        Category category = new Category();
        category.setName(request.name());

        Category saved = categoryRepository.save(category);
        return categoryMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
