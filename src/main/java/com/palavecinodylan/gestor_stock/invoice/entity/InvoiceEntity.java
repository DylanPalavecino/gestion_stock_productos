package com.palavecinodylan.gestor_stock.invoice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.palavecinodylan.gestor_stock.customer.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.models.Paymethods;
import com.palavecinodylan.gestor_stock.order.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "facturas")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    @JsonManagedReference
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private CustomerEntity customer;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Paymethods payMethod;
    private Double finalPrice;
    public static final double IVA = 0.21;
    public static final double CREDIT_SURCHARGE = 0.30;
    public static final double DEBIT_SURCHARGE = 0.15;
    public static final double TRANSFER_DISCOUNT = 0.10;
}
