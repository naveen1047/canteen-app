package com.naveen.canteenapp.menu.controller;

import com.naveen.canteenapp.menu.models.Menu;
import com.naveen.canteenapp.menu.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping
    public ResponseEntity<List<Menu>> getMenu() {
        List<Menu> menus = menuService.getMenu();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping({"/{menuId}"})
    public ResponseEntity<Menu> getMenuById(@PathVariable Long menuId) {
        return new ResponseEntity<>(menuService.getMenuById(menuId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
        Menu menu1 = menuService.addMenu(menu);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("menu", "/api/v1/menu/" + menu1.getId().toString());
        return new ResponseEntity<>(menu, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{menuId}"})
    public ResponseEntity<Menu> updateMenu(@PathVariable("menuId") Long menuId,
                                           @RequestParam("qty") int qty) {
        menuService.updateMenu(menuId,  qty);
        return new ResponseEntity<>(menuService.getMenuById(menuId), HttpStatus.OK);
    }

    @DeleteMapping({"/{menuId}"})
    public ResponseEntity<Menu> deleteMenu(@PathVariable("menuId") Long todoId) {
        menuService.deleteMenu(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
