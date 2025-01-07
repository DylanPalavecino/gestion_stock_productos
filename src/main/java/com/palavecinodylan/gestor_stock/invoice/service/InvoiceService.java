package com.palavecinodylan.gestor_stock.invoice.service;

import com.palavecinodylan.gestor_stock.invoice.request.InvoiceRequest;
import com.palavecinodylan.gestor_stock.invoice.dto.InvoiceDTO;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {
    public InvoiceDTO createInvoice(InvoiceRequest invoiceRequest) throws Exception;
    public InvoiceDTO getInvoice(Long id) throws Exception;
}
