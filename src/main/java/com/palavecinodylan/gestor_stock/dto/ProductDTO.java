package com.palavecinodylan.gestor_stock.dto;

import com.palavecinodylan.gestor_stock.models.Category;
import lombok.Data;


@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private Category category;

}
