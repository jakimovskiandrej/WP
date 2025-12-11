package mk.ukim.finki.wp.lab.model;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dishId;
    private String name;
    private String cuisine;
    private int preparationTime;

    @ManyToOne
    private Chef chef;

    public Dish(String name, String cuisine, int preparationTime, Chef chef) {
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.chef = chef;
    }


}
