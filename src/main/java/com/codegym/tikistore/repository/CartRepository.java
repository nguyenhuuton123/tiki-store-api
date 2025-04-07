package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.Cart;
import com.codegym.tikistore.entitiy.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.user.id = :userId")
    void deleteCartByUserId(@Param("userId") Long userId);
    Cart findCartBySessionId(String sessionId);

    Optional<Cart> findByUserId(Long id);
}
