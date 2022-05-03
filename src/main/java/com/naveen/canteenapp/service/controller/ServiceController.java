package com.naveen.canteenapp.service.controller;

import com.naveen.canteenapp.order.models.Order;
import com.naveen.canteenapp.service.exception.AlreadyServedException;
import com.naveen.canteenapp.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ServiceController {
    @Autowired
    ServicesService service;

    @PostMapping("/service")
    public Order putService(@RequestParam("orderId") Long orderId) throws AlreadyServedException {
        return service.putService(orderId);
    }

//    @PostMapping("/service/served")
//    public Order putServiceStatus(@RequestParam("orderId") Long orderId) throws AlreadyServedException {
//        return service.putService(orderId);
//    }
}
