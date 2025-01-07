package com.palavecinodylan.gestor_stock.order.service;

import com.palavecinodylan.gestor_stock.order.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.order.entity.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public String newEmptyOrder();
    public OrderDTO getOrderById(Long id) throws Exception;
    public OrderEntity getOrderEntityById(Long id) throws Exception;
    public String deleteItemFromOrder(Long orderId, Long itemId) throws Exception;
}


