package com.palavecinodylan.gestor_stock.dto;

import com.palavecinodylan.gestor_stock.entity.OrderItemEntity;
import com.palavecinodylan.gestor_stock.models.Category;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private Category category;

}
