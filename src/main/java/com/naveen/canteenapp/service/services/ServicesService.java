package com.naveen.canteenapp.service.services;

import com.naveen.canteenapp.order.models.Order;
import com.naveen.canteenapp.service.exception.AlreadyServedException;
import com.naveen.canteenapp.service.models.Service;

public interface ServicesService {
    Service getService(Long orderId);

    Order putService(Long orderId) throws AlreadyServedException;
}
