package esprit.tn.projetspring.Service;


import esprit.tn.projetspring.Entity.Meal;
import esprit.tn.projetspring.Interface.IMealService;
import esprit.tn.projetspring.Repository.MealRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MealService implements IMealService {
    MealRepository mealRepository;
    @Override
    public List<Meal> retrieveAllMeals() {
        return (List<Meal>) mealRepository.findAll();
    }

    @Override
    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Meal updateMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Meal retrieveMeal(long idMeal) {
        return mealRepository.findById(idMeal).orElse(null);
    }

    @Override
    public void removeMeal(long idMEal) {
        mealRepository.deleteById(idMEal);

    }
}
