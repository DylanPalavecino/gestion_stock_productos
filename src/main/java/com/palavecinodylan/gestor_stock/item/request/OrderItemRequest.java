package com.palavecinodylan.gestor_stock.item.request;


import lombok.Builder;

@Builder
public record OrderItemRequest (Long orderId, Long productId, Integer quantity) {
}
