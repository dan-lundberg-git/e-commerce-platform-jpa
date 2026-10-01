package git.lundberg.dan.ecommerce.controller;

import git.lundberg.dan.ecommerce.domain.dto.ProductRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.ProductResponseDto;
import git.lundberg.dan.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(
            @Valid
            @RequestBody
            ProductRequestDto request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.create(request));
    }

    @GetMapping
    public List<ProductResponseDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/search")
    public List<ProductResponseDto> searchByName(
            @RequestParam
            String name
    ) {
        return productService.searchByName(name);
    }
}
