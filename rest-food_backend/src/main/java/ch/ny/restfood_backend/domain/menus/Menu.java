package ch.ny.restfood_backend.domain.menus;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(min=1, max=300, message = "has to be between 1 and 300 characters")
    @Column
    private String Name;
    @NotBlank
    @Column
    private Integer Price;

}
