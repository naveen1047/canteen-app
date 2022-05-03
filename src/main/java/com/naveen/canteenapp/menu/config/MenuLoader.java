package com.naveen.canteenapp.menu.config;

import com.naveen.canteenapp.menu.dao.MenuRepository;
import com.naveen.canteenapp.menu.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuLoader implements CommandLineRunner {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public void run(String... args) throws Exception {
        loadMenu();
    }

    private void loadMenu() {
        List<Menu> menus = new ArrayList<>();

        menus.add(new Menu("Chappati", 20.0, 2));
        menus.add(new Menu("Idly", 20.0, 50));
        menus.add(new Menu("Meals", 20.0, 50));
        menus.add(new Menu("Cakes", 20.0, 50));
        menus.add(new Menu("Fresh Juice", 20.0, 50));

        menuRepository.saveAll(menus);
    }
}
