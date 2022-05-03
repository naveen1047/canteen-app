package com.naveen.canteenapp.menu.dao;

import com.naveen.canteenapp.menu.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
}
