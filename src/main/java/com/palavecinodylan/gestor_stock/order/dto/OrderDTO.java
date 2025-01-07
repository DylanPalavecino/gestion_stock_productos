package com.palavecinodylan.gestor_stock.order.dto;

import com.palavecinodylan.gestor_stock.item.entity.OrderItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Double totalPrice;
    private List<OrderItemEntity> orderItems;
}
