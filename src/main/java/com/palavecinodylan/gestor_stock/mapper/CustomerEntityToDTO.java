package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.customer.dto.CustomerDTO;
import com.palavecinodylan.gestor_stock.customer.entity.CustomerEntity;
import org.springframework.stereotype.Component;


@Component
public class CustomerEntityToDTO implements IMapper<CustomerEntity, CustomerDTO> {
    @Override
    public CustomerDTO map(CustomerEntity input) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(input.getId());
        dto.setFullName(input.getFullName());
        dto.setDni(input.getDni());
        dto.setEmail(input.getEmail());
        dto.setPhone(input.getPhone());
        dto.setInvoices(input.getInvoices());
        return dto;
    }
}
