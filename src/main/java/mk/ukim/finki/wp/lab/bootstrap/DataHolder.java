package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab.repository.mock.DishRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();
    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;

    public DataHolder(DishRepository dishRepository, ChefRepository chefRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
    }

    @PostConstruct
    public void init() {
        chefRepository.save(new Chef("Andrej","sdaasd","jahahhaha"));
        chefRepository.save(new Chef("Chef2","c2","b2"));
        chefRepository.save(new Chef("Chef3","c3","b3"));
    }

}
