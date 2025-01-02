package com.palavecinodylan.gestor_stock.service;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public String newEmptyOrder();
    public OrderDTO getOrderById(Long id) throws Exception;
    public OrderEntity getOrderEntityById(Long id) throws Exception;
    public void deleteItemFromOrder(Long orderId, Long itemId) throws Exception;


    }


