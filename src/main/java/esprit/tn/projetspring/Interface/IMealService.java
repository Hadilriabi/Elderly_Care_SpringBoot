package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.Meal;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IMealService {
    List<Meal> retrieveAllMeals();
    Meal addMeal(Meal meal, MultipartFile file);
    Meal updateMeal(Long idMeal,Meal updateMeal, MultipartFile newImage);
    Meal retrieveMeal(long idMeal);

    void removeMeal(long idMEal);
}
