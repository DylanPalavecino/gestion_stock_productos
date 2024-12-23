package com.palavecinodylan.gestor_stock.mapper;


import com.palavecinodylan.gestor_stock.dto.InvoiceDTO;
import com.palavecinodylan.gestor_stock.entity.InvoiceEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceEntityToDTO implements IMapper<InvoiceEntity, InvoiceDTO> {


    @Override
    public InvoiceDTO map(InvoiceEntity input) {
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(input.getId());
        dto.setCustomer(input.getCustomer());
        dto.setOrder(input.getOrder());
        dto.setDate(input.getDate());
        dto.setPayMethod(input.getPayMethod());
        dto.setFinalPrice(input.getFinalPrice());

        return dto;
    }
}
