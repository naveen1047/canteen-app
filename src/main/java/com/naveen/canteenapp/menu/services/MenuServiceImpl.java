package com.naveen.canteenapp.menu.services;

import com.naveen.canteenapp.menu.dao.MenuRepository;
import com.naveen.canteenapp.menu.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuRepository menuRepository;

//    public MenuServiceImpl(MenuRepository menuRepository) {
//        this.menuRepository = menuRepository;
//    }

    @Override
    public List<Menu> getMenu() {
        List<Menu> menus = new ArrayList<>();
        menuRepository.findAll().forEach(menus::add);
        return menus;
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).get();
    }

    @Override
        public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, int qty) {
        Menu menu = menuRepository.findById(id).get();
        menu.setQty(qty);
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }
}
