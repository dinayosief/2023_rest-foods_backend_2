package com.ny.restfood_backend.domain.menus;

import com.ny.restfood_backend.domain.exceptions.ResourceNotFoundException;
import com.ny.restfood_backend.domain.menus.Menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2

public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<Menu> getAllManu() {
        log.info("all menu was attempted to be accessed");
        return new ArrayList<>(menuRepository.findAllMenu());
    }

    public Reservation getMenuById(Integer id) {
        log.info("menu with id " + id + " was attempted to be accessed");
        return menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu with id " + id + " was not found."));
    }
}
