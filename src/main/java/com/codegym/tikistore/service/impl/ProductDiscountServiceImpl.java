package com.codegym.tikistore.service.impl;

import com.codegym.tikistore.entitiy.product.ProductDiscount;
import com.codegym.tikistore.repository.ProductDiscountRepository;
import com.codegym.tikistore.service.ProductDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDiscountServiceImpl implements ProductDiscountService {
    private final ProductDiscountRepository productDiscountRepository;

    public List<ProductDiscount> getCurrentDiscountsForProduct(Long productId) {
        return productDiscountRepository.findCurrentDiscountsByProductId(productId);
    }

}
