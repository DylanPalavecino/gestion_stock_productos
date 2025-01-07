package com.palavecinodylan.gestor_stock.invoice.repository;

import com.palavecinodylan.gestor_stock.invoice.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    @Query("SELECT i FROM InvoiceEntity i " +
            "JOIN FETCH i.order o " +
            "JOIN FETCH o.orderItems oi " +
            "JOIN FETCH oi.product " +
            "WHERE i.id = :id")
    Optional<InvoiceEntity> findInvoiceWithDetailsById(@Param("id") Long id);
}
