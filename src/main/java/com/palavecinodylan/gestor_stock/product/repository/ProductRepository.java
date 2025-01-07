package com.palavecinodylan.gestor_stock.product.repository;

import com.palavecinodylan.gestor_stock.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
