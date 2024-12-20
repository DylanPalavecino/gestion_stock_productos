package com.palavecinodylan.gestor_stock.service.impl;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.entity.OrderEntity;
import com.palavecinodylan.gestor_stock.entity.OrderItemEntity;
import com.palavecinodylan.gestor_stock.mapper.OrderEntityToDTO;
import com.palavecinodylan.gestor_stock.repository.OrderRepository;
import com.palavecinodylan.gestor_stock.service.OrderItemService;
import com.palavecinodylan.gestor_stock.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderEntityToDTO orderEntityToDTO;
    private OrderItemService orderItemService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderEntityToDTO orderEntityToDTO, OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.orderEntityToDTO = orderEntityToDTO;
        this.orderItemService = orderItemService;
    }

    @Override
    public OrderDTO newEmptyOrder(OrderDTO orderDTO) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderItems(Collections.emptyList());
        orderEntity.setCustomer(null);

        return orderEntityToDTO.map(orderRepository.save(orderEntity));

    }

    @Override
    public OrderDTO getOrderById(Long id) throws Exception {

        OrderEntity order = orderRepository.findById(id).orElseThrow(()-> new Exception("oli"));
        return orderEntityToDTO.map(order);

    }

    public OrderEntity getOrderEntityById(Long id) throws Exception {

       OrderEntity order = orderRepository.findById(id).orElseThrow(()-> new Exception("oli"));
       return order;

    }

    @Override
    public String addItemToOrder(Long orderId, Long itemId) throws Exception {
        OrderEntity order = getOrderEntityById(orderId);
        OrderItemEntity orderItem = orderItemService.getItemEntity(itemId);

        order.getOrderItems().add(orderItem);

        return "Item added to order";
    }
}
