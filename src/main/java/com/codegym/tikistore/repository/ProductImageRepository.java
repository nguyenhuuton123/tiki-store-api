package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}
