package com.naveen.canteenapp.order.dao;

import com.naveen.canteenapp.order.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "SELECT * FROM ORDERS WHERE \n" +
            "status NOT LIKE 'SERVED' \n" +
            "OR status IS NULL", nativeQuery = true)
    List<Order> findAllNotServedOrders();

    @Query(value = "SELECT * FROM ORDERS WHERE \n" +
            "status LIKE 'SERVED'", nativeQuery = true)
    List<Order> findServedOrders();
}
