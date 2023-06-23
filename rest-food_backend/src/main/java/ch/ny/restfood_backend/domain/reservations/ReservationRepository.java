package ch.ny.restfood_backend.domain.reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class represents the repository class for reservations
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
