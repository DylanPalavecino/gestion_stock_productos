package com.palavecinodylan.gestor_stock.invoice.request;

import com.palavecinodylan.gestor_stock.models.Paymethods;
import lombok.Builder;

@Builder
public record InvoiceRequest(Long orderId, Long customerId, Paymethods payMethod) {
}
