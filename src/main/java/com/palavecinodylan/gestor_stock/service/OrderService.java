package com.palavecinodylan.gestor_stock.service;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public OrderDTO newEmptyOrder(OrderDTO orderDTO);
    public OrderDTO getOrderById(Long id) throws Exception;
    public OrderEntity getOrderEntityById(Long id) throws Exception;
    public String addItemToOrder(Long orderId, Long itemId) throws Exception;



    }


