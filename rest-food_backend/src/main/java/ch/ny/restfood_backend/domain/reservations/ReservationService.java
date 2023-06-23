package ch.ny.restfood_backend.domain.reservations;

import ch.ny.restfood_backend.domain.exceptions.InvalidIdException;
import ch.ny.restfood_backend.domain.exceptions.InvalidTimeException;
import ch.ny.restfood_backend.domain.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for implementing crud operations for reservations
 */
@Service
@Log4j2
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    /**
     * Reads all reservations in database
     *
     * @return List of all reservations
     */
    public List<Reservation> getAllReservations() {
        log.info("all reservations was attempted to be accessed");
        return new ArrayList<>(reservationRepository.findAll());
    }

    /**
     * Reads reservation by id
     *
     * @param id id of reservation to read
     * @return desired Reservation
     */
    public Reservation getReservationById(Integer id) {
        log.info("reservation with id " + id + " was attempted to be accessed");
        return reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Error: Reservation with id " + id + " was not found."));
    }

    /**
     * Creates a new reservation in database
     *
     * @param reservation new reservation, id must be null
     */
    public void save(Reservation reservation) {
        if (reservation.getReservationId() != null) {
            throw new InvalidIdException("Error: ID has to be null");
        } else if (!reservation.getStarttime().isBefore(reservation.getEndtime())) {
            throw new InvalidTimeException("Error: End time has to be after start time");
        } else {
            reservationRepository.save(reservation);
            log.info("New reservation has been added to database");
        }
    }

    /**
     * Deletes a reservation by id if it exists in database
     *
     * @param id id of reservation to delete
     */
    public void delete(Integer id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            log.info("Reservation with id " + id + " was deleted from database");
        } else throw new ResourceNotFoundException("Error: Reservation with id " + id + " was not found.");
    }

    /**
     * Updates a reservation by id if it exists in database
     *
     * @param reservation updated reservation, id must be identical
     */
    public void update(Reservation reservation) {
        if (reservation.getReservationId() == null){
            throw new InvalidTimeException("Id must not be null");
        }
        else if (reservation.getStarttime().isBefore(reservation.getEndtime())) {
            Reservation reservationUpdate = reservationRepository.findById(reservation.getReservationId()).orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + reservation.getReservationId() + " was not found."));

            reservationUpdate.setLastname(reservation.getLastname());
            reservationUpdate.setDate(reservation.getDate());
            reservationUpdate.setStarttime(reservation.getStarttime());
            reservationUpdate.setEndtime(reservation.getEndtime());
            reservationUpdate.setPersons(reservation.getPersons());
            reservationUpdate.setTel(reservation.getTel());
            reservationUpdate.setTablenumber(reservation.getTablenumber());

            reservationRepository.save(reservationUpdate);

            log.info("Reservation with id " + reservationUpdate.getReservationId() + "was updated.");
        } else throw new InvalidTimeException("Error: End time has to be after start time");
    }
}
