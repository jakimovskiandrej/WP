package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.jpa.DishRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;

    public DishServiceImpl(DishRepository dishRepository, ChefRepository chefRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
//        return dishRepository.findByDishId(dishId);
        return null;
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public void deleteById(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public Dish create(String name, String cuisine, int preparationTime, Long chefId) {
        if(name.isEmpty() || cuisine.isEmpty() || preparationTime < 0) {
            throw new IllegalArgumentException();
        }
        Chef chef = chefRepository.findById(chefId).orElse(null);
        Dish dish = new Dish(name,cuisine,preparationTime,chef);
        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Long id, String name, String cuisine, int preparationTime) {
        Dish dish = dishRepository.findById(id).orElse(null);
        if(dish != null) {
            dish.setName(name);
            dish.setCuisine(cuisine);
            dish.setPreparationTime(preparationTime);
            return dishRepository.save(dish);
        }
        return null;
    }

}
