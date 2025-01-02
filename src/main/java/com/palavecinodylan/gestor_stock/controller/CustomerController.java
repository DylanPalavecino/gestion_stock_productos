package com.palavecinodylan.gestor_stock.controller;
import com.palavecinodylan.gestor_stock.dto.CustomerDTO;
import com.palavecinodylan.gestor_stock.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO>createCustomer(@RequestBody CustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO>getCustomer(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>>getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CustomerDTO>updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO dto) throws Exception {
        return ResponseEntity.ok(customerService.updateCustomer(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }



}
