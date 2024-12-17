package com.palavecinodylan.gestor_stock.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "clientes")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String dni;
    private String email;
    private String phone;

    @OneToMany(targetEntity = OrderEntity.class, fetch = FetchType.LAZY, mappedBy = "customer")
    private List<OrderEntity> orderHistory;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderEntity> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<OrderEntity> orderHistory) {
        this.orderHistory = orderHistory;
    }
}