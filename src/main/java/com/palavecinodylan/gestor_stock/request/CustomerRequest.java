package com.palavecinodylan.gestor_stock.request;

import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequest {

    private String fullName;
    private String dni;
    private String email;
    private String phone;

}
