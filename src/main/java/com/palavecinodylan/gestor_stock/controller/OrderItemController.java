package com.palavecinodylan.gestor_stock.controller;

import com.palavecinodylan.gestor_stock.controller.request.OrderItemRequest;
import com.palavecinodylan.gestor_stock.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody OrderItemRequest orderItemRequest) throws Exception {
        return ResponseEntity.ok(orderItemService.addItem(orderItemRequest));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getItem(Long id) throws Exception {
        return ResponseEntity.ok(orderItemService.getItemEntity(id));
    }

}
