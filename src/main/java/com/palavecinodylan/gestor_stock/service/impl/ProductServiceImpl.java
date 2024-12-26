package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import com.palavecinodylan.gestor_stock.exception.ObjectNotFoundException;
import com.palavecinodylan.gestor_stock.mapper.ProductEntityToDTO;
import com.palavecinodylan.gestor_stock.repository.ProductRepository;
import com.palavecinodylan.gestor_stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductEntityToDTO productEntityToDTO;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream().map(productEntityToDTO::map).toList();

    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        ProductEntity product = productRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Product not found"));
        return productEntityToDTO.map(product);
    }

    @Override
    public ProductDTO addProduct(ProductDTO dto) {

        ProductEntity product = new ProductEntity();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory(dto.getCategory());

        return productEntityToDTO.map(productRepository.save(product));

    }

    @Override
    public ProductDTO updateProduct(ProductDTO dto, Long id) throws Exception {

        ProductEntity product = productRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Product not found"));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory(dto.getCategory());

        return productEntityToDTO.map(productRepository.save(product));

    }

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public ProductEntity getProductEntityById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
