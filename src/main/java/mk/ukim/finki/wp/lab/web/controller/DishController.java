package mk.ukim.finki.wp.lab.web.controller;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    public String getDishesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        model.addAttribute("dishes", dishService.listDishes());
        model.addAttribute("bodyContent", "listDishes");
        return "master-template";
    }

    @PostMapping
    public String saveDish(@RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime) {
        dishService.create(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime) {
        dishService.update(id,dishId,name,cuisine,preparationTime);
        return "redirect:/dishes";
    }

    @PostMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id) {
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @GetMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model) {
        if(dishService.findById(id) == null) {
            return "redirect:/dishes?error=DishNotFound.";
        }
        model.addAttribute("dish", dishService.findById(id));
        model.addAttribute("bodyContent", "dish-form");
        return "master-template";
    }

    @GetMapping("/dish-form")
    public String getAddDishPage(Model model) {
        model.addAttribute("bodyContent", "dish-form");
        return "master-template";
    }

    @GetMapping("/listChefs")
    public String getListChefs(Model model) {
        model.addAttribute("chefs", chefService.listChefs());
        return "listChefs";
    }

}
