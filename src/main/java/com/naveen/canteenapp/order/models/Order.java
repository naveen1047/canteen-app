package com.naveen.canteenapp.order.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.naveen.canteenapp.menu.models.Menu;
import com.naveen.canteenapp.user.models.User;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    Long id;

    public Long getId() {
        return id;
    }
//    @Column(name = "status")
    String status;
    LocalDateTime serviceTime;

    @Column(name = "time")
//    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss")
    LocalDateTime time;

    @Column(name = "menu_list")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderMenu> menuList;

    @Column(name = "total")
    double total;

    public LocalDateTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalDateTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @ManyToOne
    User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(LocalDateTime time, List<OrderMenu> menuList, double total, User user) {
        this.time = time;
        this.menuList = menuList;
        this.total = total;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(LocalDateTime time, User user, List<OrderMenu> menuList) {
        this.time = time;
        this.user = user;
        this.menuList = menuList;
    }

    public List<OrderMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<OrderMenu> menuList) {
        this.menuList = menuList;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
