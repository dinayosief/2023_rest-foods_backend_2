package ch.ny.restfood_backend.domain.menus;

import ch.ny.restfood_backend.domain.menus.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This class represents the repository class for menus
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
