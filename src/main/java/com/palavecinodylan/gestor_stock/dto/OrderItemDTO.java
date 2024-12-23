package com.palavecinodylan.gestor_stock.dto;

import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class OrderItemDTO {

    private OrderEntity order;
    private ProductEntity product;
    private Integer quantity;
    private Double subTotal;

}
