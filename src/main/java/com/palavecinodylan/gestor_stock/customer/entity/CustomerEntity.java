package com.palavecinodylan.gestor_stock.customer.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.palavecinodylan.gestor_stock.invoice.entity.InvoiceEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Builder
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
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<InvoiceEntity> invoices;
    @JoinColumn(nullable = false)
    private String fullName;
    @Column(unique = true)
    @Size(min = 8, max = 10)
    private String dni;
    private String email;
    private String phone;
}