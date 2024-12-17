package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.dto.ProductDTO;

import com.palavecinodylan.gestor_stock.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {


    @Override
    public OrderDTO getOrder(Long id) {
        return null;
    }

    @Override
    public OrderDTO generateOrder(OrderDTO dto) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllCustomerOrders(Long customerId) {
        return List.of();
    }

    @Override
    public List<ProductDTO> getAllProductsInOrder(Long orderId) {
        return List.of();
    }
}
