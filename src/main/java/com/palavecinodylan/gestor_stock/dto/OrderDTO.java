package com.palavecinodylan.gestor_stock.dto;

import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.entity.OrderItemEntity;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Double totalPrice;
    private List<OrderItemEntity> orderItems;
    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
