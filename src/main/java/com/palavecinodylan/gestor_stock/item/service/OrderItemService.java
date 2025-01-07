package com.palavecinodylan.gestor_stock.item.service;

import com.palavecinodylan.gestor_stock.item.request.OrderItemRequest;
import com.palavecinodylan.gestor_stock.item.dto.OrderItemDTO;
import com.palavecinodylan.gestor_stock.item.entity.OrderItemEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderItemService {
    public OrderItemDTO addItem(OrderItemRequest orderItemRequest) throws Exception;
    public OrderItemEntity getItemEntity(Long id) throws Exception;
}
