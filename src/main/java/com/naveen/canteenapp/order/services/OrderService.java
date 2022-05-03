package com.naveen.canteenapp.order.services;

import com.naveen.canteenapp.order.dto.OrderAcknowledgement;
import com.naveen.canteenapp.order.dto.OrderRequest;
import com.naveen.canteenapp.order.models.Order;

import java.util.List;

public interface OrderService {
    OrderAcknowledgement orderFood(OrderRequest request) throws Exception;

    List<Order> getOrders(String username);

    Order getOrder(String username, Long id);

    List<Order> getAllOrders();

    List<Order> getServedOrders();

    List<Order> getNotServedOrders();
}
