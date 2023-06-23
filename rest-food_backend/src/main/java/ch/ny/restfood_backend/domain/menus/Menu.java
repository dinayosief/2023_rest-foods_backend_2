package ch.ny.restfood_backend.domain.menus;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer menuId;
    @NotBlank
    private String Name;
    @NotBlank
    private String Price;

}
