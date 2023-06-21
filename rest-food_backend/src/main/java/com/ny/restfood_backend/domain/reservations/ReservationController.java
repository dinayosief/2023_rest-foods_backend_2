package com.ny.restfood_backend.domain.reservations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    /**
     * Returns a ResponseEntity containing List of all Reservations currently on the database
     * @return ResponseEntity containing List of all Reservations
     */
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations(){
        return ResponseEntity.ok().body(reservationService.getAllReservations());
    }

    /**
     * Returns a ResponseEntity containing Reservation with specific id
     * @param reservationId id of desired reservation
     * @return ResponseEntity containing Reservation with said id
     */
    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("reservationId") Integer reservationId){
        return ResponseEntity.ok().body(reservationService.getReservationById(reservationId));
    }

    /**
     * Deletes a reservation by id
     * @param reservationId id of reservation to delete
     */
    @DeleteMapping("/{reservationId}")
    public void deleteReservation(@PathVariable("reservationId") Integer reservationId){
        reservationService.delete(reservationId);
    }

    /**
     * Saves a new reservation in database
     * @param reservation reservation object,id is null
     * @return ResponseEntity ok if method was completed
     */
    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
        reservationService.save(reservation);
        return ResponseEntity.ok(reservation);
    }

    /**
     * Updates an existing reservation
     * @param reservation updated reservation object, id should match
     * @return ResponseEntity ok if method was completed
     */
    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
        reservationService.update(reservation);
        return ResponseEntity.ok(reservation);
    }


}
