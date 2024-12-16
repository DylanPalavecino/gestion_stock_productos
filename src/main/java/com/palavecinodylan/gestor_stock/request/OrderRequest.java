package com.palavecinodylan.gestor_stock.request;

import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import com.palavecinodylan.gestor_stock.entity.status.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequest {

    private Double totalPrice;
    private OrderStatus status;
    private LocalDate orderDate;
    private CustomerEntity customer;
    private List<ProductEntity> products;

}
