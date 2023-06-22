package com.ny.restfood_backend.domain.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * Returns a ResponseEntity containing List of all Menus currently on the database
     *
     * @return ResponseEntity containing List of all Menus
     */
    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenu() {
        return ResponseEntity.ok().body(menuService.getAllManu());
    }

    /**
     * Returns a ResponseEntity containing Reservation with specific id
     *
     * @param menuId id of desired reservation
     * @return ResponseEntity containing Reservation with said id
     */
    @GetMapping("/{manuId}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("manuId") Integer menuId) {
        return ResponseEntity.ok().body(menuService.getMenuById(manuId));
    }


}
