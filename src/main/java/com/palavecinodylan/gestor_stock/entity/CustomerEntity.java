package com.palavecinodylan.gestor_stock.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "customer")
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

}