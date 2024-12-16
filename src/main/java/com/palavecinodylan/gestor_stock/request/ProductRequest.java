package com.palavecinodylan.gestor_stock.request;

import lombok.Data;


@Data
public class ProductRequest {

    private String name;
    private Double price;
    private Integer quantity;
    private String description;

}
