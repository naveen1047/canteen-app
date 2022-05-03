package com.naveen.canteenapp.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Data
public class OrderResponse {
    String username;
    LocalDateTime localDateTime;
    double total;
    List<MenuQty> items;
}
