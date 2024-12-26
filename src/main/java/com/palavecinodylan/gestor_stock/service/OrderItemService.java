package com.palavecinodylan.gestor_stock.service;

import com.palavecinodylan.gestor_stock.controller.request.OrderItemRequest;
import com.palavecinodylan.gestor_stock.dto.OrderItemDTO;
import com.palavecinodylan.gestor_stock.entity.OrderItemEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemService {

    public OrderItemDTO newItem(OrderItemRequest orderItemRequest) throws Exception;
    public OrderItemEntity getItemEntity(Long id) throws Exception;
    public List<OrderItemDTO> getAllItemsInOrder(Long orderId) throws Exception;
}
