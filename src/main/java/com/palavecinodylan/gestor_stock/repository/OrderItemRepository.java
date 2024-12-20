package com.palavecinodylan.gestor_stock.repository;

import com.palavecinodylan.gestor_stock.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
