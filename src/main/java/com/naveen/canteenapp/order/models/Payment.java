package com.naveen.canteenapp.order.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    Long id;

    @Column(name = "amount")
    int amount;

    @OneToOne
    Order order;

    public Payment(int amount, Order order) {
        this.amount = amount;
        this.order = order;
    }
}
