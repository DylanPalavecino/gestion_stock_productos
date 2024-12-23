package com.palavecinodylan.gestor_stock.controller;

import com.palavecinodylan.gestor_stock.dto.ProductDTO;
import com.palavecinodylan.gestor_stock.service.ProductService;
import com.palavecinodylan.gestor_stock.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.addProduct(dto));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO dto,@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(productService.updateProduct(dto, id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }



}
