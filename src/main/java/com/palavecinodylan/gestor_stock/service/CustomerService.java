package com.palavecinodylan.gestor_stock.service;

import com.palavecinodylan.gestor_stock.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {


    public CustomerDTO createCustomer(CustomerDTO dto);
    public CustomerDTO getCustomer(Long customerId);
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO dto);
    public void deleteCustomer(Long customerId);


}
