package com.palavecinodylan.gestor_stock.service;


import com.palavecinodylan.gestor_stock.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.request.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(Long id);
    public ProductDTO addProduct(ProductRequest productRequest);
    public ProductDTO updateProduct(ProductRequest productRequest, Long id);
    public void deleteProduct(Long id);



}
