package esprit.tn.projetspring.Controller;


import esprit.tn.projetspring.Entity.Flower;
import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.Meal;
import esprit.tn.projetspring.Interface.IFuneralService;
import esprit.tn.projetspring.Interface.IMealService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/meals")
public class MealController {
    IMealService mealService;

    @PostMapping("/addMeal")
    public Meal addMeal(@ModelAttribute
    Meal meal,@RequestParam("image")
    MultipartFile file) {
        return mealService.addMeal(meal,file);
    }

    @PutMapping("/updateMeal/{idMeal}")
    public Meal updateMeal(
            @PathVariable("idMeal") Long idMeal,
            @ModelAttribute Meal updateMeal,
            @RequestParam(value = "image", required = false) MultipartFile newImage) {

        return mealService.updateMeal(idMeal, updateMeal, newImage);
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
