package com.naveen.canteenapp.order.models;

import com.naveen.canteenapp.menu.models.Menu;

import javax.persistence.*;

@Entity
@Table(name = "order_menu")
public class OrderMenu {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "qty")
    int qty;

    @Column(name = "menu_id")
    Long menuId;


    @OneToOne
    @JoinColumn(name = "menu_id_value", referencedColumnName = "id", nullable = false)
    Menu menu;
//    @ManyToOne
//    Order order;

    public OrderMenu(int qty, Long menuId) {
        this.qty = qty;
        this.menuId = menuId;
    }

    public OrderMenu(int qty, Long menuId, Menu menu) {
        this.qty = qty;
        this.menuId = menuId;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public OrderMenu() {
    }

    public OrderMenu(Long id, int qty, Long menuId) {
        this.id = id;
        this.qty = qty;
        this.menuId = menuId;
    }

    public OrderMenu(int qty, Long menuId, Order order) {
        this.qty = qty;
        this.menuId = menuId;
//        this.order = order;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
