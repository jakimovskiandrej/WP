package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.data.domain.Page;


import java.util.List;

public interface DishService {

    List<Dish> findAll();

    Dish findByDishId(String dishId);

    Dish findById(Long id);

    Dish save(Dish dish);

    void deleteById(Long id);

    Dish create(
            String name,
            String cuisine,
            int preparationTime,
            Long chefId
    );

    Dish update(
            Long id,
            String name,
            String cuisine,
            int preparationTime
    );

}