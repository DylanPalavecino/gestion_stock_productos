package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.controller.request.OrderItemRequest;
import com.palavecinodylan.gestor_stock.dto.OrderItemDTO;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import com.palavecinodylan.gestor_stock.entity.OrderItemEntity;
import com.palavecinodylan.gestor_stock.entity.ProductEntity;
import com.palavecinodylan.gestor_stock.mapper.OrderItemEntityToDTO;
import com.palavecinodylan.gestor_stock.repository.OrderItemRepository;
import com.palavecinodylan.gestor_stock.service.OrderItemService;
import com.palavecinodylan.gestor_stock.service.OrderService;
import com.palavecinodylan.gestor_stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemEntityToDTO orderItemEntityToDTO;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;
    private final OrderService orderService;

    @Override
    public OrderItemDTO addItem(OrderItemRequest orderItemRequest) throws Exception {


        ProductEntity product = productService.getProductEntityById(orderItemRequest.productId());

        Double subtotal = product.getPrice() * orderItemRequest.quantity();

        OrderItemEntity orderItem = OrderItemEntity.builder()
                .quantity(orderItemRequest.quantity())
                .order(orderService.getOrderEntityById(orderItemRequest.orderId()))
                .product(product)
                .subTotal(subtotal)
                .build();

        return orderItemEntityToDTO.map(orderItemRepository.save(orderItem));

    }

    @Override
    public OrderItemEntity getItemEntity(Long id) throws Exception {

        OrderItemEntity orderItem = orderItemRepository.findById(id).orElse(null);

        return orderItem;


    }

}


