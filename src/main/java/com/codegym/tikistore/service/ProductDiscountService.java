package com.codegym.tikistore.service;

import com.codegym.tikistore.entitiy.product.ProductDiscount;

import java.util.List;

public interface ProductDiscountService {
    List<ProductDiscount> getCurrentDiscountsForProduct(Long productId);
}
