package com.ny.restfood_backend.domain.menus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MenuRepository {

    @Repository
    public interface ReservationRepository extends JpaRepository<Menu, Integer> {
    }

}
