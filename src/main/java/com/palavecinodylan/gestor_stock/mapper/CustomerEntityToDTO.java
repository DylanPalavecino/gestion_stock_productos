package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.dto.CustomerDTO;
import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import org.springframework.stereotype.Component;


@Component
public class CustomerEntityToDTO implements IMapper<CustomerEntity, CustomerDTO> {

    @Override
    public CustomerDTO map(CustomerEntity input) {

        CustomerDTO dto = new CustomerDTO();
        dto.setFullName(input.getFullName());
        dto.setDni(input.getDni());
        dto.setEmail(input.getEmail());
        dto.setPhone(input.getPhone());

        return dto;

    }
}
