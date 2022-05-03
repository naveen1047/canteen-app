package com.naveen.canteenapp.service.dao;

import com.naveen.canteenapp.service.models.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    @Query(value = "SELECT * FROM SERVICES s WHERE s.order_id = ?1",
    nativeQuery = true)
    Service findByOrderId(Long orderId);
}
