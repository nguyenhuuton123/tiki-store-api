package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
