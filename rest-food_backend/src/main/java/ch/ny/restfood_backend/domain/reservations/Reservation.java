package ch.ny.restfood_backend.domain.reservations;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer reservationId;

    @Column
    private LocalDate date;

    @Column
    private LocalDateTime time;

    @Column
    @PositiveOrZero
    private Integer persons;

    @Column
    @PositiveOrZero
    private Integer tableNumber;
}