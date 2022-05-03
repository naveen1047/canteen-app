package com.naveen.canteenapp.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuQty {
    Long menuId;
    int qty;
}
