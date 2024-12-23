package com.palavecinodylan.gestor_stock.service;


import com.palavecinodylan.gestor_stock.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(Long id) throws Exception;
    public ProductDTO addProduct(ProductDTO dto);
    public ProductDTO updateProduct(ProductDTO dto, Long id) throws Exception;
    public void deleteProduct(Long id);
    public ProductEntity getProductEntityById(Long id);


}
