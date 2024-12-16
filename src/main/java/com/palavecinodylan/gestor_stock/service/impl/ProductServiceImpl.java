package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import com.palavecinodylan.gestor_stock.mapper.ProductEntityToDTO;
import com.palavecinodylan.gestor_stock.mapper.ProductRequestToEntity;
import com.palavecinodylan.gestor_stock.repository.ProductRepository;
import com.palavecinodylan.gestor_stock.request.ProductRequest;
import com.palavecinodylan.gestor_stock.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductEntityToDTO productEntityToDTO;
    private final ProductRequestToEntity productRequestToEntity;

    @Override
    public List<ProductDTO> getAllProducts() {

        List<ProductEntity> products = productRepository.findAll();
        return products.stream().map(productEntityToDTO::map).collect(Collectors.toList());

    }

    @Override
    public ProductDTO getProductById(Long id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        return productEntityToDTO.map(product);
    }

    @Override
    public ProductDTO addProduct(ProductRequest productRequest) {

        ProductEntity product = productRepository.save(productRequestToEntity.map(productRequest));
        return productEntityToDTO.map(product);

    }

    @Override
    public ProductDTO updateProduct(ProductRequest productRequest, Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
