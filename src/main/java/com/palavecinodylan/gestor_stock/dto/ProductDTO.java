package com.palavecinodylan.gestor_stock.dto;

import com.palavecinodylan.gestor_stock.entity.CategoryEntity;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
