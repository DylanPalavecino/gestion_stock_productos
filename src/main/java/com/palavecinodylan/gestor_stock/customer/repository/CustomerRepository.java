package com.palavecinodylan.gestor_stock.customer.repository;

import com.palavecinodylan.gestor_stock.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
