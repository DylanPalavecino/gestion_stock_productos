package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityToDTO implements IMapper<OrderEntity, OrderDTO> {


    @Override
    public OrderDTO map(OrderEntity input) {
        OrderDTO dto = new OrderDTO();
        dto.setId(input.getId());
        dto.setOrderItems(input.getOrderItems());
        dto.setTotalPrice(input.getTotalPrice());
        return dto;
    }
}
