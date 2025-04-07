package com.codegym.tikistore.service;

import com.codegym.tikistore.dto.CartDTO;
import com.codegym.tikistore.dto.CartItemDTO;
import com.codegym.tikistore.entitiy.product.Cart;
import com.codegym.tikistore.entitiy.user.User;

public interface CartService {
    CartDTO addToCart(User user,String sessionId, Long productId, int quantity);
    CartDTO getCart(User user, String id);
    void deleteCartItem(CartItemDTO cartItemDTO);
    void mergeCarts(String sessionId, User user);
    void deleteCartByUserId(Long userId);
    CartDTO updateCart(User user, String sessionId, CartDTO cartDTO);
}
