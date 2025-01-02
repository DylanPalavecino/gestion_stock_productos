package com.palavecinodylan.gestor_stock.controller;

import com.palavecinodylan.gestor_stock.controller.request.InvoiceRequest;
import com.palavecinodylan.gestor_stock.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/invoice")
@RestController
public class InvoiceController {

    @Autowired
    private final InvoiceService invoiceService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateInvoice(@RequestBody InvoiceRequest invoiceRequest) throws Exception {
        return ResponseEntity.ok(invoiceService.createInvoice(invoiceRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoice(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }
}
