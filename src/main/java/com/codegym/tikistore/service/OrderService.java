package com.codegym.tikistore.service;

import com.codegym.tikistore.dto.CartDTO;
import com.codegym.tikistore.dto.OrderDTO;
import com.codegym.tikistore.entitiy.user.User;

public interface OrderService {
    OrderDTO processOrder(User user, String sessionId, OrderDTO orderDTO);

}
