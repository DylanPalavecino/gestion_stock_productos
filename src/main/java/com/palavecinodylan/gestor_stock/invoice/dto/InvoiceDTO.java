package com.palavecinodylan.gestor_stock.invoice.dto;

import com.palavecinodylan.gestor_stock.customer.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.order.entity.OrderEntity;

import com.palavecinodylan.gestor_stock.models.Paymethods;
import lombok.Data;

import java.time.LocalDate;


@Data
public class InvoiceDTO {
    private Long id;
    private OrderEntity order;
    private CustomerEntity customer;
    private LocalDate date;
    private Paymethods payMethod;
    private Double finalPrice;
}
