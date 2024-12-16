package com.palavecinodylan.gestor_stock.repository;

import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
