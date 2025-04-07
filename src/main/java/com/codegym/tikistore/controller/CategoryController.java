package com.codegym.tikistore.controller;

import com.codegym.tikistore.dto.ProductDTO;
import com.codegym.tikistore.entitiy.product.Category;
import com.codegym.tikistore.service.CategoryService;
import com.codegym.tikistore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@SpringBootApplication(scanBasePackages = "com.codegym.tikistore")

public class CategoryController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/{categoryName}")
    public ResponseEntity<Page<ProductDTO>> getProductsByCategory(
            @PageableDefault(size = 12, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable String categoryName) {
        Page<ProductDTO> products = productService.getProductsByCategory(categoryName, pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
