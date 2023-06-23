package ch.ny.restfood_backend.domain.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * Returns a ResponseEntity containing List of all Menus currently on the database
     *
     * @return ResponseEntity containing List of all Menus
     */
    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok().body(menuService.getAllMenus());
    }

    /**
     * Returns a ResponseEntity containing Menu with specific id
     *
     * @param menuId id of desired menu
     * @return ResponseEntity containing Menu with said id
     */
    @GetMapping("/{menuId}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("menuId") Integer menuId) {
        return ResponseEntity.ok().body(menuService.getMenuById(menuId));
    }
}