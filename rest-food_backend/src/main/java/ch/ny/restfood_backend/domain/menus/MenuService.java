package ch.ny.restfood_backend.domain.menus;

import ch.ny.restfood_backend.domain.exceptions.InvalidIdException;
import ch.ny.restfood_backend.domain.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for implementing the crud operations for menus
 */
@Service
@Log4j2
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    /**
     * Reads all menus in database
     *
     * @return List of all menus
     */
    public List<Menu> getAllMenus() {
        log.info("all menus were attempted to be accessed");
        return new ArrayList<>(menuRepository.findAll());
    }

    /**
     * Reads a menu by id
     *
     * @param id id of menu to read
     * @return desired menu
     */
    public Menu getMenuById(Integer id) {
        log.info("menus with id " + id + " was attempted to be accessed");
        return menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu with id " + id + " was not found."));
    }

    /**
     * Creates a new menu in database
     *
     * @param menu new reservation, id must be null
     */
    public void save(Menu menu) {
        if (menu.getMenuId() != null) {
            throw new InvalidIdException("Error: ID has to be null");
        } else {
            menuRepository.save(menu);
            log.info("New menu has been added to database");
        }
    }

    /**
     * Deletes a menu by id if it exists in database
     *
     * @param id id of menu to delete
     */
    public void delete(Integer id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            log.info("Menu with id " + id + " was deleted from database");
        } else throw new ResourceNotFoundException("Error: Menu with id " + id + " was not found.");
    }

    /**
     * Updates a menu by id if it exists in database
     *
     * @param menu updated menu, id must be the same
     */
    public void update(Menu menu) {
        if (menu.getMenuId() == null) {
            throw new InvalidIdException("Error: Id must not be null");
        } else {
            Menu menuUpdate = menuRepository.findById(menu.getMenuId()).orElseThrow(() -> new ResourceNotFoundException("Menu with id " + menu.getMenuId() + " was not found."));

            menuUpdate.setDescription(menu.getDescription());
            menuUpdate.setImg(menu.getImg());
            menuUpdate.setType(menu.getType());
            menuUpdate.setPrice(menu.getPrice());
            menuUpdate.setName(menu.getName());
            menuRepository.save(menuUpdate);

            log.info("Menu with id " + menuUpdate.getMenuId() + "was updated.");
        }
    }
}
