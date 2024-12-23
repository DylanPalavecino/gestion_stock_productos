package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.controller.request.InvoiceRequest;
import com.palavecinodylan.gestor_stock.dto.InvoiceDTO;
import com.palavecinodylan.gestor_stock.entity.CustomerEntity;
import com.palavecinodylan.gestor_stock.entity.InvoiceEntity;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;

import com.palavecinodylan.gestor_stock.mapper.InvoiceEntityToDTO;
import com.palavecinodylan.gestor_stock.repository.CustomerRepository;
import com.palavecinodylan.gestor_stock.repository.InvoiceRepository;
import com.palavecinodylan.gestor_stock.service.CustomerService;
import com.palavecinodylan.gestor_stock.service.InvoiceService;
import com.palavecinodylan.gestor_stock.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public InvoiceDTO getInvoiceById(Long id) throws Exception {

        InvoiceEntity invoice = invoiceRepository.findById(id).orElseThrow(()-> new Exception("Invoice not found"));
        return invoiceEntityToDTO.map(invoice);

    }
}
