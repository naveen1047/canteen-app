package com.naveen.canteenapp.order.controller;

import com.naveen.canteenapp.menu.models.Menu;
import com.naveen.canteenapp.order.dto.OrderAcknowledgement;
import com.naveen.canteenapp.order.dto.OrderRequest;
import com.naveen.canteenapp.order.models.Order;
import com.naveen.canteenapp.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public Order getOrder(@RequestParam("username") String username, @RequestParam("orderId") Long orderId) {
        return orderService.getOrder(username, orderId);
    }

    @GetMapping("/all/servedOrder")
    public List<Order> getServedOrder() {
        return orderService.getServedOrders();
    }

    @GetMapping("/all/notServedOrder")
    public List<Order> getNotServedOrder() {
        return orderService.getNotServedOrders();
    }

    @GetMapping("/all/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders")
    public List<Order> getOrder(@RequestParam("username") String username) {
        return orderService.getOrders(username);
    }

    @PostMapping("/order")
    public OrderAcknowledgement order(@RequestBody OrderRequest request) throws Exception {
        return orderService.orderFood(request);
    }
}
