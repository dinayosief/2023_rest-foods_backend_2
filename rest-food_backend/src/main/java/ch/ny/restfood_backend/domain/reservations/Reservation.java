package ch.ny.restfood_backend.domain.reservations;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private String lastname;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime starttime;

    @Column
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endtime;

    @Column
    @PositiveOrZero
    private Integer persons;

    @Column
    private String tel;

    @Column
    @PositiveOrZero
    private Integer tablenumber;
}