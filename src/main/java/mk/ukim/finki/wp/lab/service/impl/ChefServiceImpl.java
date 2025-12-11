package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;

    public ChefServiceImpl(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    @Override
    public List<Chef> findAll() {
        return chefRepository.findAll();
    }

    @Override
    public Optional<Chef> findById(Long id) {
        return chefRepository.findById(id);
    }

    @Override
    public Chef save(Chef chef) {
        return chefRepository.save(chef);
    }

    @Override
    public Chef create(String firstName, String lastName, String bio) {
        if(firstName.isEmpty() || lastName.isEmpty() || bio.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Chef chef = new Chef(firstName,lastName,bio);
        return chefRepository.save(chef);
    }

    @Override
    public Chef update(Long id, String firstName, String lastName, String bio) {
        if(firstName.isEmpty() || lastName.isEmpty() || bio.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Chef chef = chefRepository.findById(id).orElse(null);
        if(chef == null) {
            throw new IllegalArgumentException();
        }
        chef.setFirstName(firstName);
        chef.setLastName(lastName);
        chef.setBio(bio);
        return chefRepository.save(chef);
    }

    @Override
    public void delete(Long id) {
        chefRepository.deleteById(id);
    }

}
