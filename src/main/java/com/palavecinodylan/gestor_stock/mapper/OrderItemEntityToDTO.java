package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.item.dto.OrderItemDTO;
import com.palavecinodylan.gestor_stock.item.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderItemEntityToDTO implements IMapper<OrderItemEntity, OrderItemDTO> {
    @Override
    public OrderItemDTO map(OrderItemEntity input) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setQuantity(input.getQuantity());
        dto.setProduct(input.getProduct());
        dto.setSubTotal(input.getSubTotal());
        return dto;
    }
}
