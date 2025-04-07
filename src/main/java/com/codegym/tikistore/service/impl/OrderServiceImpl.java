package com.codegym.tikistore.service.impl;

import com.codegym.tikistore.constants.OrderStatus;
import com.codegym.tikistore.dto.AddressDTO;
import com.codegym.tikistore.dto.OrderDTO;
import com.codegym.tikistore.entitiy.product.Cart;
import com.codegym.tikistore.entitiy.product.Order;
import com.codegym.tikistore.entitiy.product.OrderItem;
import com.codegym.tikistore.entitiy.user.Address;
import com.codegym.tikistore.entitiy.user.User;
import com.codegym.tikistore.repository.AddressRepository;
import com.codegym.tikistore.repository.CartItemRepository;
import com.codegym.tikistore.repository.CartRepository;
import com.codegym.tikistore.repository.OrderRepository;
import com.codegym.tikistore.service.CartService;
import com.codegym.tikistore.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final MailSender mailSender;
    private final CartService cartService;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    @Transactional
    public OrderDTO processOrder(User user, String sessionId, OrderDTO orderDTO) {
        Order order = new Order();
        order.setStatus(OrderStatus.PENDING);
        order.setDateCreated(LocalDateTime.now().toString());
        order.setTotal(orderDTO.getTotal());
        AddressDTO addressDTO = orderDTO.getAddressDTO();
        if (user != null) {
            order.setUser(user);
            sendOrderConfirmationEmail(user.getEmail());
            Cart cart = cartRepository.findByUserId(user.getId()).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
            cartItemRepository.deleteByCartId(cart.getId());
            cartRepository.delete(cart);
        }
        Address address;

        if (addressDTO.getId() != null) {
            address = addressRepository.findById(addressDTO.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid address ID"));
        } else {
            address = new Address();
            address.setStreet(addressDTO.getStreet());
            address.setCity(addressDTO.getCity());
            address.setDistrict(addressDTO.getDistrict());
            address.setWard(addressDTO.getWard());
            address.setUser(user);
            address.setIsDeleted(false);
            addressRepository.save(address);
        }
        order.setAddress(address);
        List<OrderItem> orderItems = orderDTO.getItems().stream()
                .map(itemDTO -> {
                    OrderItem item = modelMapper.map(itemDTO, OrderItem.class);
                    item.setId(null);
                    item.setOrder(order);
                    return item;
                })
                .collect(Collectors.toList());

        order.setItems(orderItems);
        orderRepository.save(order);

        orderDTO.getAddressDTO().setId(address.getId());
        return orderDTO;
    }

    private void sendOrderConfirmationEmail(String customerEmail) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("tranhuutjnh@gmail.com");
            message.setTo(customerEmail);
            message.setSubject("Order Confirmation");
            message.setText("Thank you for your order! Your order has been confirmed.");
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

}
