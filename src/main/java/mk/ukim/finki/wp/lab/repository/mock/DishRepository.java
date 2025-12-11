package mk.ukim.finki.wp.lab.repository.mock;

import mk.ukim.finki.wp.lab.model.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(String dishId);
    Dish findById(Long id);
    Dish save(Dish dish);
    void deleteById(Long id);
}