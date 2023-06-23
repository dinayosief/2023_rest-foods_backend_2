package ch.ny.restfood_backend.domain.menus;

import ch.ny.restfood_backend.domain.exceptions.IdNotNullException;
import ch.ny.restfood_backend.domain.reservations.Reservation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    /**
     * Deletes a reservation by id
     *
     * @param menuId id of menu to delete
     */
    @DeleteMapping("/{menuId}")
    @Operation(summary = "delete a menu", description = "This method deletes a menu by its index")
    public void deleteMenu(@PathVariable("menuId") Integer menuId) {
        menuService.delete(menuId);
    }

    /**
     * Saves a new menu in database
     *
     * @param menu menu object,id is null
     * @return ResponseEntity ok if method was completed
     */
    @PostMapping
    @Operation(summary = "create a new menu", description = "creates a new menu from request body in database")
    public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseEntity.ok(menu);
    }

    /**
     * Updates an existing menu
     *
     * @param menu updated menu object, id should match
     * @return ResponseEntity ok if method was completed
     */
    @PutMapping
    @Operation(summary = "update a menu", description = "updates a menu with the request body by id")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) {
        menuService.update(menu);
        return ResponseEntity.ok(menu);
    }
    /**
     * Handles MethodArgumentNotValidException
     * @param manve
     * @return 400 error and error message
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleManveException(MethodArgumentNotValidException manve){
        return ResponseEntity.status(400).body(Objects.requireNonNull(manve.getFieldError()).getDefaultMessage());
    }
    /**
     * Handles IdNotNullException
     * @param inn
     * @return 400 error and error message
     */
    @ExceptionHandler(IdNotNullException.class)
    public ResponseEntity<String> handleInnException(IdNotNullException inn){
        return ResponseEntity.status(400).body(inn.getMessage());
    }

}