package com.palavecinodylan.gestor_stock.entity;

import com.palavecinodylan.gestor_stock.models.Paymethods;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "customer_id")
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
