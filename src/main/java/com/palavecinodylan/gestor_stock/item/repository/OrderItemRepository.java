package com.palavecinodylan.gestor_stock.item.repository;

import com.palavecinodylan.gestor_stock.item.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
