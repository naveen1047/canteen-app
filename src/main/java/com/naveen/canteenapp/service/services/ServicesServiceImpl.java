package com.naveen.canteenapp.service.services;

import com.naveen.canteenapp.order.dao.OrderRepository;
import com.naveen.canteenapp.order.models.Order;
import com.naveen.canteenapp.service.dao.ServiceRepository;
import com.naveen.canteenapp.service.exception.AlreadyServedException;
import com.naveen.canteenapp.service.models.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Service getService(Long orderId) {
        return serviceRepository.findByOrderId(orderId);
    }

    @Override
    public Order putService(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        Service service = new Service();
        LocalDateTime time = LocalDateTime.now();

        if (serviceRepository.findByOrderId(orderId) != null && !order.getStatus().equals("SERVED")) {
            order.setStatus("SERVED");
            service.setLocalDateTime(time);
            order.setServiceTime(time);

            serviceRepository.save(service);

        } else if (serviceRepository.findByOrderId(orderId) == null) {
            service.setOrder(order);
            service.setLocalDateTime(time);
            order.setServiceTime(time);

            order.setStatus("READY");
            serviceRepository.save(service);
        }

        return orderRepository.findById(orderId).get();
    }
}
