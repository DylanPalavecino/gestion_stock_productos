package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.dto.CustomerDTO;
import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.exception.ObjectNotFoundException;
import com.palavecinodylan.gestor_stock.mapper.CustomerEntityToDTO;
import com.palavecinodylan.gestor_stock.repository.CustomerRepository;

import com.palavecinodylan.gestor_stock.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerEntityToDTO customerEntityToDTO;


    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFullName(dto.getFullName());
        customerEntity.setInvoices(dto.getInvoices());
        customerEntity.setDni(dto.getDni());
        customerEntity.setPhone(dto.getPhone());
        customerEntity.setEmail(dto.getEmail());

        return customerEntityToDTO.map(customerRepository.save(customerEntity));

    }

    @Override
    public CustomerDTO getCustomer(Long customerId) throws Exception {

        return customerEntityToDTO.map(customerRepository.findById(customerId).orElseThrow(()-> new ObjectNotFoundException("Customer not found")));

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<CustomerEntity> customers = customerRepository.findAll();
        return customers.stream().map(customerEntityToDTO::map).toList();

    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO dto) throws Exception {

        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(()-> new ObjectNotFoundException("Customer not found"));
        customer.setFullName(dto.getFullName());
        customer.setInvoices(dto.getInvoices());
        customer.setDni(dto.getDni());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());

        return customerEntityToDTO.map(customerRepository.save(customer));

    }

    @Override
    public void deleteCustomer(Long customerId) {

        customerRepository.deleteById(customerId);

    }

    @Override
    public CustomerEntity getCustomerEntityById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
