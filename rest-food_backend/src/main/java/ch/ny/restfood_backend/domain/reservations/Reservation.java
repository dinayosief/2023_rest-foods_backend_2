package ch.ny.restfood_backend.domain.reservations;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
    @Size(min=1, max=300, message = "has to be between 1 and 300 characters")
    private String name;

    @Column
    @PositiveOrZero
    private Integer price;

}