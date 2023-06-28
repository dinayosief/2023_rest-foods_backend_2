package ch.ny.restfood_backend.domain.menus;

import ch.ny.restfood_backend.domain.exceptions.InvalidIdException;
import ch.ny.restfood_backend.domain.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * This class is responsible for implementing the endpoints for all CRUD operations for menus
 */
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
    @Operation(summary = "get all menus", description = "This method returns a list of all menus")
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
    @Operation(summary = "get a menu by id", description = "This method returns a menu by its index")
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
    @Operation(summary = "create a new menu", description = "This method creates a new menu using the request body")
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
    @Operation(summary = "update a menu", description = "This method updates a menu using the request body identified by a matching id ")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) {
        menuService.update(menu);
        return ResponseEntity.ok(menu);
    }
    /**
     * Handles ResourceNotFoundException
     * @param rnfe ResourceNotFoundException
     * @return 404 error and error message
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleRnfeException(ResourceNotFoundException rnfe){
        return ResponseEntity.status(404).body(rnfe.getMessage());
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
     * Handles InvalidIdException
     * @param ii
     * @return 400 error and error message
     */
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<String> handleIiException(InvalidIdException ii){
        return ResponseEntity.status(400).body(ii.getMessage());
    }

    /**
     * Handles HttpMessageNotReadableException
     * @param hmnr HttpMessageNotReadableException
     * @return 400 error and error message
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHmnrException(HttpMessageNotReadableException hmnr){
        return ResponseEntity.status(400).body("Invalid arguments, please check format \n \n \"menuId\": Integer(PUT) or null(POST) \n \"type\": String \n \"img\": String \n \"name\": String \n \"price\": Double \n \"description\": String");
    }

}