package esprit.tn.projetspring.Repository;

import esprit.tn.projetspring.Entity.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal,Long> {
    List<Meal> findByNameMealLike(String nomMeal);
}
