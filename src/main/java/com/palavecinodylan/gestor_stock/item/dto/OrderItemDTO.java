package com.palavecinodylan.gestor_stock.item.dto;

import com.palavecinodylan.gestor_stock.product.entity.ProductEntity;
import lombok.Data;

@Data
public class OrderItemDTO {
    private ProductEntity product;
    private Integer quantity;
    private Double subTotal;
}
