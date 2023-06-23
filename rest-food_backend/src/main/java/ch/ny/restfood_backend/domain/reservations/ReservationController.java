package ch.ny.restfood_backend.domain.reservations;

import ch.ny.restfood_backend.domain.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * This class is responsible for implementing the endpoints for all CRUD operations on reservations
 */
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
    @Operation(summary = "get all reservations", description = "This method returns a list of all saved reservations")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        return ResponseEntity.ok().body(reservationService.getAllReservations());
    }

    /**
     * Returns a ResponseEntity containing Reservation with specific id
     * @param reservationId id of desired reservation
     * @return ResponseEntity containing Reservation with said id
     */
    @GetMapping("/{reservationId}")
    @Operation(summary = "read a reservation by id", description = "This method returns a reservation by its index")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("reservationId") Integer reservationId){
        return ResponseEntity.ok().body(reservationService.getReservationById(reservationId));
    }

    /**
     * Deletes a reservation by id
     * @param reservationId id of reservation to delete
     */
    @DeleteMapping("/{reservationId}")
    @Operation(summary = "delete a reservation", description = "This method deletes a reservation by its index")
    public void deleteReservation(@PathVariable("reservationId") Integer reservationId){
        reservationService.delete(reservationId);
    }

    /**
     * Saves a new reservation in database
     * @param reservation reservation object,id is null
     * @return ResponseEntity ok if method was completed
     */
    @PostMapping
    @Operation(summary = "create a new reservation", description = "creates a new reservation from request body in database")
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
    @Operation(summary = "update a reservation", description = "updates a reservation with the request body by id")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
        reservationService.update(reservation);
        return ResponseEntity.ok(reservation);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleRnfeException(ResourceNotFoundException rnfe){
        return ResponseEntity.status(404).body(rnfe.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleManveException(MethodArgumentNotValidException manve){
        return ResponseEntity.status(400).body(Objects.requireNonNull(manve.getFieldError()).getDefaultMessage());
    }


}
