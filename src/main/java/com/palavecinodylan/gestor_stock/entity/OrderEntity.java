package com.palavecinodylan.gestor_stock.entity;

import com.palavecinodylan.gestor_stock.entity.status.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pedidos")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;
    private OrderStatus status;
    private LocalDate orderDate;

    @ManyToOne(targetEntity = CustomerEntity.class)
    private CustomerEntity customer;

    @ManyToMany(targetEntity = ProductEntity.class, fetch = FetchType.LAZY)
    private List<ProductEntity> products;


}