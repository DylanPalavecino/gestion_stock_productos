package com.palavecinodylan.gestor_stock.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
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

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private InvoiceEntity invoice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItemEntity> orderItems;


}