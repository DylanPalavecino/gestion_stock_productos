package com.palavecinodylan.gestor_stock.controller.request;
import com.palavecinodylan.gestor_stock.models.Paymethods;
import lombok.Builder;

import java.util.List;

@Builder
public record InvoiceRequest (Long orderId, Long customerId, Paymethods payMethod){

}
