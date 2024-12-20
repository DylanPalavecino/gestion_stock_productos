package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;

public class OrderEntityToDTO implements IMapper<OrderEntity, OrderDTO> {


    @Override
    public OrderDTO map(OrderEntity input) {
        OrderDTO dto = new OrderDTO();
        return dto;
    }
}
