package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecificationRepository extends JpaRepository<Specification, Long> {
}
