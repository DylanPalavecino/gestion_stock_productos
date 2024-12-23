package com.palavecinodylan.gestor_stock.dto;

import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;

import com.palavecinodylan.gestor_stock.models.Paymethods;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InvoiceDTO {

    private Long id;
    private OrderEntity order;
    private CustomerEntity customer;
    private LocalDate date;
    private Paymethods payMethod;
    private Double finalPrice;

}
