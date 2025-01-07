package com.palavecinodylan.gestor_stock.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.palavecinodylan.gestor_stock.invoice.entity.InvoiceEntity;
import com.palavecinodylan.gestor_stock.item.entity.OrderItemEntity;
import jakarta.persistence.*;
import lombok.*;
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
    @JsonBackReference
    private InvoiceEntity invoice;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrderItemEntity> orderItems;
}