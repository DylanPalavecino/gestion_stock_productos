package com.palavecinodylan.gestor_stock.repository;

import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
