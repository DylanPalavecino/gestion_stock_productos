package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToDTO implements IMapper<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO map(ProductEntity input) {
        ProductDTO dto = new ProductDTO();
        dto.setName(input.getName());
        dto.setDescription(input.getDescription());
        dto.setPrice(input.getPrice());
        dto.setQuantity(input.getQuantity());
        return dto;
    }
}
