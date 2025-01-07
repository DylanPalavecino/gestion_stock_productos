package com.palavecinodylan.gestor_stock.order.service.impl;

import com.palavecinodylan.gestor_stock.order.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.order.entity.OrderEntity;
import com.palavecinodylan.gestor_stock.item.entity.OrderItemEntity;
import com.palavecinodylan.gestor_stock.exception.ObjectNotFoundException;
import com.palavecinodylan.gestor_stock.mapper.OrderEntityToDTO;
import com.palavecinodylan.gestor_stock.order.repository.OrderRepository;
import com.palavecinodylan.gestor_stock.item.service.OrderItemService;
import com.palavecinodylan.gestor_stock.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEntityToDTO orderEntityToDTO;
    private OrderItemService orderItemService;
    @Override
    public String newEmptyOrder() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderItems(new ArrayList<>());
        orderEntity.setTotalPrice(0.0);
        orderRepository.save(orderEntity);
        return "New order created whit id: "+ orderEntity.getId();
    }
    @Override
    public OrderDTO getOrderById(Long id) throws Exception {
        OrderEntity order = orderRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Order not found"));
        return orderEntityToDTO.map(order);
    }
    public OrderEntity getOrderEntityById(Long id) throws Exception {
       OrderEntity order = orderRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("OrderEntity not found"));
       return order;
    }


    @Override
    public String deleteItemFromOrder(Long orderId, Long itemId) throws Exception {
        OrderEntity order = getOrderEntityById(orderId);
        OrderItemEntity orderItem = orderItemService.getItemEntity(itemId);
        if (!order.getOrderItems().contains(orderItem)) {
            throw new Exception("Item not in order");
        }
        order.getOrderItems().remove(orderItem);
        order.setTotalPrice(order.getTotalPrice() - orderItem.getSubTotal());
        orderRepository.save(order);
        return "Item removed from order";
    }
}
