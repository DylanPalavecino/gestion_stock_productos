package com.palavecinodylan.gestor_stock.controller;

import com.palavecinodylan.gestor_stock.controller.request.InvoiceRequest;
import com.palavecinodylan.gestor_stock.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RequestMapping("/api/invoice")
@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateInvoice(@RequestBody InvoiceRequest invoiceRequest) throws Exception {
        return ResponseEntity.ok(invoiceService.createInvoice(invoiceRequest));
    }


}
