package git.lundberg.dan.ecommerce.service;

import git.lundberg.dan.ecommerce.domain.dto.ProductRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto productRequestDto);

    List<ProductResponseDto> findAll();

    List<ProductResponseDto> searchByName(String name);
}
