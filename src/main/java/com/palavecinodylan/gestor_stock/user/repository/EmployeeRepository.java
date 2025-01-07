package com.palavecinodylan.gestor_stock.user.repository;

import com.palavecinodylan.gestor_stock.user.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
