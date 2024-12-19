package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.Meal;

import java.util.List;

public interface IMealService {
    List<Meal> retrieveAllMeals();
    Meal addMeal(Meal meal);
    Meal updateMeal(Meal meal);
    Meal retrieveMeal(long idMeal);

    void removeMeal(long idMEal);
}
