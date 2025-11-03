package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = null;
    public static List<Dish> dishes = null;

    @PostConstruct
    public void init() {
        chefs = new ArrayList<>();
        dishes = new ArrayList<>();

        chefs.add(new Chef(1L, "Andrej", "Jakimovski", "Iskusen gotvach za italijanska kujna", new ArrayList<>()));
        chefs.add(new Chef(2L, "Marija", "Petrova", "Specijalist za mediteranski jadenja", new ArrayList<>()));
        chefs.add(new Chef(3L, "Bojan", "Ilievski", "Poznat po gurmanski burgeri i skara", new ArrayList<>()));
        chefs.add(new Chef(4L, "Elena", "Stojanova", "Ekspert za vegetarijanska i veganska kujna", new ArrayList<>()));
        chefs.add(new Chef(5L, "Ivan", "Nikolov", "Majstor za deserti i slatki specijaliteti", new ArrayList<>()));

        dishes.add(new Dish("10", "Pasta Carbonara", "Italian", 25));
        dishes.add(new Dish("11", "Grilled Salmon", "Mediterranean", 30));
        dishes.add(new Dish("12", "Caesar Salad", "American", 15));
        dishes.add(new Dish("13", "Beef Burger", "American", 20));
        dishes.add(new Dish("14", "Chocolate Lava Cake", "French", 40));
    }

}
