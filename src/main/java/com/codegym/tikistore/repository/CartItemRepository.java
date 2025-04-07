package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteByCartId(Long id);       
}
