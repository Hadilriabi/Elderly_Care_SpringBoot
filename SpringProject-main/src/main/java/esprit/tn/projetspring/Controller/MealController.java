package esprit.tn.projetspring.Controller;


import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.Meal;
import esprit.tn.projetspring.Interface.IFuneralService;
import esprit.tn.projetspring.Interface.IMealService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/meals")
public class MealController {
    IMealService mealService;

    @PostMapping("/addMeal")
    public Meal addMeal(@RequestBody Meal meal) {
        return mealService.addMeal(meal);
    }

    @PutMapping("/updateMeal")
    public Meal updateMeal(@RequestBody Meal meal) {
        return mealService.updateMeal(meal);
    }

    @GetMapping("/retrieveMeal/{idMeal}")
    public  Meal retrieveMeal(@PathVariable("idMeal") long idMeal) {
        return mealService.retrieveMeal(idMeal);
    }
    @DeleteMapping("/removeMeal/{idMeal}")
    public void removeMeal(@PathVariable("idMeal") long idMeal) {
        mealService.removeMeal(idMeal);
    }


    @GetMapping("/retrieveAllMeals")
    public List<Meal> retrieveAllMeals() {
        return mealService.retrieveAllMeals();
    }
}
