package com.palavecinodylan.gestor_stock.service;

import com.palavecinodylan.gestor_stock.dto.OrderDTO;
import com.palavecinodylan.gestor_stock.dto.ProductDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public OrderDTO getOrder(Long id);
    public OrderDTO generateOrder(OrderDTO dto);

    //Traer todos los pedidos del cliente
    public List<OrderDTO> getAllCustomerOrders(Long customerId);

    //Traer los productos que estan en el pedido
    public List<ProductDTO> getAllProductsInOrder(Long orderId);



}
