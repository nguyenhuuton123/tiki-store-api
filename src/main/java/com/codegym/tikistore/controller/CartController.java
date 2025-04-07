package com.codegym.tikistore.controller;

import com.codegym.tikistore.dto.CartDTO;
import com.codegym.tikistore.dto.CartItemDTO;
import com.codegym.tikistore.repository.UserRepository;
import com.codegym.tikistore.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserRepository userRepository;

    @PostMapping("/add/{productId}")
    public ResponseEntity<CartDTO> addToCart(
            @PathVariable Long productId,
            HttpSession session,
            @AuthenticationPrincipal User authUser,
            @RequestParam(defaultValue = "1") int quantity) {
        CartDTO cartDTO;
        if (authUser == null) {
            cartDTO = cartService.addToCart(null, session.getId(), productId, quantity);

        } else {
            com.codegym.tikistore.entitiy.user.User user = userRepository.findUserByUsername(authUser.getUsername());
            cartDTO = cartService.addToCart(user, session.getId(), productId, quantity);
        }
        return ResponseEntity.ok()
                .header("Session-Id", session.getId())
                .body(cartDTO);
    }

    @GetMapping()
    public ResponseEntity<CartDTO> getCart(
            @AuthenticationPrincipal User authUser,
            HttpSession session) {

        CartDTO cartDTO;
        if (authUser == null) {
            cartDTO = cartService.getCart(null, session.getId());

        } else {
            com.codegym.tikistore.entitiy.user.User user = userRepository.findUserByUsername(authUser.getUsername());
            cartDTO = cartService.getCart(user, session.getId());
        }
        return ResponseEntity.ok()
                .header("Session-Id", session.getId())
                .body(cartDTO);

    }

    @PostMapping("/merge")
    public ResponseEntity<Void> mergeCarts(HttpSession session,
                                           @AuthenticationPrincipal User authUser) {

        com.codegym.tikistore.entitiy.user.User user = userRepository.findUserByUsername(authUser.getUsername());
        cartService.mergeCarts(session.getId(), user);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/update")
    public ResponseEntity<CartDTO> updateCart(
            @RequestBody CartDTO cartDTO,
            @AuthenticationPrincipal User authUser,
            HttpSession session
    ) {
        if (authUser == null) {
            cartDTO = cartService.updateCart(null, session.getId(), cartDTO);

        } else {
            com.codegym.tikistore.entitiy.user.User user = userRepository.findUserByUsername(authUser.getUsername());
            cartDTO = cartService.updateCart(user, session.getId(), cartDTO);
        }
        return ResponseEntity.ok()
                .body(cartDTO);

    }

    @DeleteMapping("/delete")
    public void deleteCartItem(@RequestBody CartItemDTO cartItemDTO) {
        cartService.deleteCartItem(cartItemDTO);
    }

}
