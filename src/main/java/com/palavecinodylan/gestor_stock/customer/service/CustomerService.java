package com.palavecinodylan.gestor_stock.customer.service;

import com.palavecinodylan.gestor_stock.customer.dto.CustomerDTO;
import com.palavecinodylan.gestor_stock.customer.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public CustomerDTO createCustomer(CustomerDTO dto);
    public CustomerDTO getCustomer(Long customerId) throws Exception;
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO dto) throws Exception;
    public String deleteCustomer(Long customerId);
    public CustomerEntity getCustomerEntityById(Long id);
}
