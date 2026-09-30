package git.lundberg.dan.ecommerce.service.impl;

import git.lundberg.dan.ecommerce.domain.dto.ProductRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.ProductResponseDto;
import git.lundberg.dan.ecommerce.mapper.ProductMapper;
import git.lundberg.dan.ecommerce.repository.CategoryRepository;
import git.lundberg.dan.ecommerce.repository.ProductRepository;
import git.lundberg.dan.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return List.of();
    }

    @Override
    public List<ProductResponseDto> searchByName(String name) {
        return List.of();
    }
}
