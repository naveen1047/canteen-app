package com.naveen.canteenapp.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Data
public class OrderRequest {
    String userid;
    List<MenuQty> menuQty;
}
