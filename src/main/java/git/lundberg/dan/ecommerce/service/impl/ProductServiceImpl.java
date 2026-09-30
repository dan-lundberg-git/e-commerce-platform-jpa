package git.lundberg.dan.ecommerce.service.impl;

import git.lundberg.dan.ecommerce.domain.dto.ProductRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.ProductResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.Category;
import git.lundberg.dan.ecommerce.domain.entity.Product;
import git.lundberg.dan.ecommerce.exception.ResourceNotFoundException;
import git.lundberg.dan.ecommerce.mapper.ProductMapper;
import git.lundberg.dan.ecommerce.repository.CategoryRepository;
import git.lundberg.dan.ecommerce.repository.ProductRepository;
import git.lundberg.dan.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
            ProductMapper productMapper
    ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public ProductResponseDto create(ProductRequestDto request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category not found: " + request.categoryId()));

        Product product = productRepository.save(productMapper.toEntity(request, category));
        return productMapper.toResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(productMapper::toResponse)
                .toList();
    }
}
