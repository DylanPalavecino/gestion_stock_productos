package com.palavecinodylan.gestor_stock.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;


    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;
    private Integer quantity;
    private Double subTotal;


}
