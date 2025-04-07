package com.codegym.tikistore.service.impl;

import com.codegym.tikistore.entitiy.product.Category;
import com.codegym.tikistore.repository.CategoryRepository;
import com.codegym.tikistore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ADMIN
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
