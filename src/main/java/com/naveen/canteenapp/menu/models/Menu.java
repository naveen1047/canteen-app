package com.naveen.canteenapp.menu.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
//@Builder
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;
    @Column
    String name;
    @Column
    double price;
    @Column
    int qty;


    public Menu() {
    }

    public Menu(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}
