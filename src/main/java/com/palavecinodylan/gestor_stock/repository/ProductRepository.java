package com.palavecinodylan.gestor_stock.repository;

import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
