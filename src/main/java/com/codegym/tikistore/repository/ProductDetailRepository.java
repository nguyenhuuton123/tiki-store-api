package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    ProductDetail findProductDetailByProductId(Long productId);
}
