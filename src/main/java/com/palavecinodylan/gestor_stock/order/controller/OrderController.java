package com.palavecinodylan.gestor_stock.order.controller;

import com.palavecinodylan.gestor_stock.order.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/empty-order")
    public ResponseEntity<String> createEmptyOrder() {
        return ResponseEntity.ok(orderService.newEmptyOrder());
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PostMapping("/remove-item/{orderId}/{itemId}")
    public ResponseEntity<?> deleteItemFromOrder(@PathVariable Long orderId,@PathVariable Long itemId) throws Exception {
        orderService.deleteItemFromOrder(orderId, itemId);
        return ResponseEntity.ok().build();
    }
}
