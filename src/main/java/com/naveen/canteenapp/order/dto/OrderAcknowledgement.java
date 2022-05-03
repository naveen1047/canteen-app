package com.naveen.canteenapp.order.dto;

import com.naveen.canteenapp.order.models.Order;
import com.naveen.canteenapp.user.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class OrderAcknowledgement {
    String status;
    Order order;
}
