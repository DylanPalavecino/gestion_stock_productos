package com.palavecinodylan.gestor_stock.mapper;

import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import com.palavecinodylan.gestor_stock.request.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestToEntity implements IMapper<ProductRequest, ProductEntity> {

    public ProductEntity map(ProductRequest input) {
        ProductEntity product = new ProductEntity();
        product.setName(input.getName());
        product.setDescription(input.getDescription());
        product.setPrice(input.getPrice());
        product.setQuantity(input.getQuantity());
        return product;
    }

}
