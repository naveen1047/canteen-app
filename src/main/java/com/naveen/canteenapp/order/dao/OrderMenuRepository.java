package com.naveen.canteenapp.order.dao;

import com.naveen.canteenapp.order.models.OrderMenu;
import org.springframework.data.repository.CrudRepository;

public interface OrderMenuRepository extends CrudRepository<OrderMenu, Long> {
}
