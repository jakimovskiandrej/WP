package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;

import java.util.List;
import java.util.Optional;

public interface ChefService {
    List<Chef> findAll();

    Optional<Chef> findById(Long id);

    Chef save(Chef chef);

    Chef create(
            String firstName,
            String lastName,
            String bio
    );
    Chef update(
            Long id,
            String firstName,
            String lastName,
            String bio
    );

    void delete(Long id);

}