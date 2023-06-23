package ch.ny.restfood_backend.domain.reservations;

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

    public List<Reservation> getAllReservations(){
        log.info("all reservations was attempted to be accessed");
        return new ArrayList<>(reservationRepository.findAll());
    }

    public Reservation getReservationById(Integer id){
        log.info("reservation with id " + id + " was attempted to be accessed");
        return reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " was not found."));
    }

    public void save(Reservation reservation){
        reservationRepository.save(reservation);
        log.info("New reservation has been added to database");
    }

    public void delete(Integer id){
        reservationRepository.deleteById(id);
        log.info("Reservation with id " + id + " was deleted from database");
    }

    public void update(Reservation reservation){
        Reservation reservationUpdate = reservationRepository.findById(reservation.getReservationId()).orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + reservation.getReservationId() + " was not found."));

        //set other attributes

        reservationRepository.save(reservationUpdate);

        log.info("Reservation with id " + reservationUpdate.getReservationId() + "was updated.");
    }
}
