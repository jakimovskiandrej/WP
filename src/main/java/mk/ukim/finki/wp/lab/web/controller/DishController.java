package mk.ukim.finki.wp.lab.web.controller;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping
    public String getDishesPage(@RequestParam(required = false)
                                    String error,
                                    Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        model.addAttribute("dishes", dishService.findAll());
        model.addAttribute("bodyContent", "listDishes");
        return "master-template";
    }

    @PostMapping("/addDish")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveDish(@RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime,
                           @RequestParam Long chef) {
        dishService.create(name,cuisine,preparationTime,chef);
        return "redirect:/dishes";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editDish(@PathVariable Long id,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime) {
        dishService.update(id,name,cuisine,preparationTime);
        return "redirect:/dishes";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteDish(@PathVariable Long id) {
        dishService.deleteById(id);
        return "redirect:/dishes";
    }

    @GetMapping("/dish-form/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditDishForm(@PathVariable Long id, Model model) {
        if(dishService.findById(id) == null) {
            return "redirect:/dishes?error=DishNotFound.";
        }
        model.addAttribute("dish", dishService.findById(id));
        model.addAttribute("bodyContent", "dish-form");
        return "master-template";
    }

    @GetMapping("/dish-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAddDishPage(Model model) {
        model.addAttribute("bodyContent", "dish-form");
        model.addAttribute("chefs", chefService.findAll());
        return "master-template";
    }

    @GetMapping("/listChefs")
    public String getListChefs(Model model) {
        model.addAttribute("chefs", chefService.findAll());
        return "listChefs";
    }

}
