package com.palavecinodylan.gestor_stock.invoice.controller;

import com.palavecinodylan.gestor_stock.invoice.dto.InvoiceDTO;
import com.palavecinodylan.gestor_stock.invoice.request.InvoiceRequest;
import com.palavecinodylan.gestor_stock.invoice.service.InvoiceService;
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
    public ResponseEntity<InvoiceDTO> generateInvoice(@RequestBody InvoiceRequest invoiceRequest) throws Exception {
        return ResponseEntity.ok(invoiceService.createInvoice(invoiceRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }
}
