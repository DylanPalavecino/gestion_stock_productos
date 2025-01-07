package com.palavecinodylan.gestor_stock.invoice.service.impl;

import com.palavecinodylan.gestor_stock.invoice.request.InvoiceRequest;
import com.palavecinodylan.gestor_stock.invoice.dto.InvoiceDTO;
import com.palavecinodylan.gestor_stock.customer.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.invoice.entity.InvoiceEntity;
import com.palavecinodylan.gestor_stock.order.entity.OrderEntity;

import com.palavecinodylan.gestor_stock.exception.ObjectNotFoundException;
import com.palavecinodylan.gestor_stock.mapper.InvoiceEntityToDTO;
import com.palavecinodylan.gestor_stock.invoice.repository.InvoiceRepository;
import com.palavecinodylan.gestor_stock.customer.service.CustomerService;
import com.palavecinodylan.gestor_stock.invoice.service.InvoiceService;
import com.palavecinodylan.gestor_stock.order.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceEntityToDTO invoiceEntityToDTO;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Override
    public InvoiceDTO createInvoice(InvoiceRequest invoiceRequest) throws Exception {
        OrderEntity order = orderService.getOrderEntityById(invoiceRequest.orderId());
        CustomerEntity customer = customerService.getCustomerEntityById(invoiceRequest.customerId());
        double finalPrice = order.getTotalPrice() * (1 + InvoiceEntity.IVA);
        if (customer.getInvoices() == null) {
            customer.setInvoices(new ArrayList<>());
        }
        InvoiceEntity invoice = InvoiceEntity.builder()
                .order(order)
                .customer(customer)
                .date(LocalDate.now())
                .payMethod(invoiceRequest.payMethod())
                .finalPrice(
                        finalPrice = switch (invoiceRequest.payMethod()) {
                            case CASH -> finalPrice;
                            case CREDIT_CARD -> finalPrice * (1 + InvoiceEntity.CREDIT_SURCHARGE);
                            case DEBIT_CARD -> finalPrice * (1 + InvoiceEntity.DEBIT_SURCHARGE);
                            case TRANSFER -> finalPrice * (1 + InvoiceEntity.TRANSFER_DISCOUNT);
                            default -> finalPrice;
                        }
                )
                .build();
        customer.getInvoices().add(invoice);
        return invoiceEntityToDTO.map(invoiceRepository.save(invoice));
    }
    @Override
    public InvoiceDTO getInvoice(Long id) throws Exception {
        InvoiceEntity invoice = invoiceRepository.findInvoiceWithDetailsById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Invoice not found"));
        return invoiceEntityToDTO.map(invoice);
    }

}
