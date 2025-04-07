package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.Category;
import com.codegym.tikistore.entitiy.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
    List<Category> findAll();
}
