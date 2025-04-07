package com.codegym.tikistore.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private AddressDTO addressDTO;

    private Double total;

    private List<OrderItemDTO> items;
}
