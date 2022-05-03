package com.naveen.canteenapp.menu.services;

import com.naveen.canteenapp.menu.models.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu();

    Menu getMenuById(Long id);

    Menu addMenu(Menu menu);

    Menu updateMenu(Long id, int qty);

    void deleteMenu(Long menuId);
}
