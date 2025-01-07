package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.product.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToDTO implements IMapper<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO map(ProductEntity input) {
        ProductDTO dto = new ProductDTO();
        dto.setId(input.getId());
        dto.setName(input.getName());
        dto.setPrice(input.getPrice());
        dto.setCategory(input.getCategory());
        dto.setStock(input.getStock());
        return dto;
    }
}
