package com.naveen.canteenapp.service.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.naveen.canteenapp.order.models.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue
    Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss")
    LocalDateTime localDateTime;

    @OneToOne
    Order order;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Service(LocalDateTime localDateTime, Order order) {
        this.localDateTime = localDateTime;
        this.order = order;
    }
}
