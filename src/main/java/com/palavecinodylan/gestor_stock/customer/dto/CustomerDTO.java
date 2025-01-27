package com.palavecinodylan.gestor_stock.customer.dto;

import com.palavecinodylan.gestor_stock.invoice.entity.InvoiceEntity;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String fullName;
    private String dni;
    private String email;
    private String phone;
}
