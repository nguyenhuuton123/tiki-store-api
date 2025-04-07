package com.codegym.tikistore.controller;

import com.codegym.tikistore.dto.OrderDTO;
import com.codegym.tikistore.repository.UserRepository;
import com.codegym.tikistore.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final UserRepository userRepository;
    private final OrderService orderService;

    @PostMapping("/proceed")
    public ResponseEntity<OrderDTO> proceedToOrder(@RequestBody OrderDTO orderDTO,
                                                   @AuthenticationPrincipal User authUser,
                                                   HttpSession session
    ) {
        if (authUser == null) {
            orderDTO = orderService.processOrder(null, session.getId(), orderDTO);

        } else {
            com.codegym.tikistore.entitiy.user.User user = userRepository.findUserByUsername(authUser.getUsername());

            orderDTO = orderService.processOrder(user, session.getId(), orderDTO);
        }
        return ResponseEntity.ok()
                .body(orderDTO);
    }
}
