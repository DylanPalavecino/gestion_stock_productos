package com.palavecinodylan.gestor_stock.dto;

import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import lombok.Data;

@Data
public class OrderItemDTO {

    private ProductEntity product;
    private Integer quantity;
    private Double subTotal;

}
