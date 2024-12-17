package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import com.palavecinodylan.gestor_stock.mapper.ProductEntityToDTO;
import com.palavecinodylan.gestor_stock.repository.ProductRepository;
import com.palavecinodylan.gestor_stock.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductEntityToDTO productEntityToDTO;

    public ProductServiceImpl(ProductRepository productRepository, ProductEntityToDTO productEntityToDTO) {
        this.productRepository = productRepository;
        this.productEntityToDTO = productEntityToDTO;
    }

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
    public ProductDTO addProduct(ProductDTO dto) {

        return null;


    }

    @Override
    public ProductDTO updateProduct(ProductDTO dto, Long id) {

        ProductEntity product = productRepository.findById(id).orElse(null);
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        productRepository.save(product);
        return productEntityToDTO.map(product);

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
