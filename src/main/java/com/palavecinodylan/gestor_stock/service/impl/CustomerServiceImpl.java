package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.dto.CustomerDTO;
import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.mapper.CustomerEntityToDTO;
import com.palavecinodylan.gestor_stock.repository.CustomerRepository;

import com.palavecinodylan.gestor_stock.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerEntityToDTO customerEntityToDTO;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerEntityToDTO customerEntityToDTO) {
        this.customerRepository = customerRepository;
        this.customerEntityToDTO = customerEntityToDTO;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {

        return null;

    }

    @Override
    public CustomerDTO getCustomer(Long customerId) {

        return customerEntityToDTO.map(customerRepository.findById(customerId).orElse(null));

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<CustomerEntity> customers = customerRepository.findAll();
        return customers.stream().map(customerEntityToDTO::map).collect(Collectors.toList());

    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO dto) {

        CustomerEntity customer = customerRepository.findById(customerId).orElse(null);
        customer.setFullName(dto.getFullName());
        customer.setDni(dto.getDni());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());

        return customerEntityToDTO.map(customerRepository.save(customer));

    }

    @Override
    public void deleteCustomer(Long customerId) {

        customerRepository.deleteById(customerId);

    }
}
