package git.lundberg.dan.ecommerce.controller;

import git.lundberg.dan.ecommerce.domain.dto.CategoryRequestDto;
import git.lundberg.dan.ecommerce.domain.dto.CategoryResponseDto;
import git.lundberg.dan.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(
            @Valid
            @RequestBody
            CategoryRequestDto resuest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.create(resuest));
    }

    @GetMapping
    public List<CategoryResponseDto> findAll() {
        return categoryService.findAll();
    }
}
