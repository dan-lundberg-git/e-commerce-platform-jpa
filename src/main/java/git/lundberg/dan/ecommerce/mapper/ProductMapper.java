package git.lundberg.dan.ecommerce.mapper;

import git.lundberg.dan.ecommerce.domain.dto.ProductRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.ProductResponseDto;
import git.lundberg.dan.ecommerce.domain.entity.Category;
import git.lundberg.dan.ecommerce.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductResponseDto toResponse(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                List.copyOf(product.getImageUrls()),
                product.getCategory().getName()
        );
    }

    public Product toEntity(ProductRequestDto request, Category category) {
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);
        return product;
    }
}
