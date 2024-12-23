package com.palavecinodylan.gestor_stock.service;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public String newEmptyOrder();
    public OrderDTO getOrderById(Long id) throws Exception;
    public OrderEntity getOrderEntityById(Long id) throws Exception;
    public OrderDTO deleteItemFromOrder(Long orderId, Long itemId) throws Exception;

    }


