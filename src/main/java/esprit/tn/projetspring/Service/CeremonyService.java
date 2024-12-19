package esprit.tn.projetspring.Service;

import esprit.tn.projetspring.Entity.*;
import esprit.tn.projetspring.Interface.ICeremonyService;
import esprit.tn.projetspring.Repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CeremonyService implements ICeremonyService {
    CeremonyRepository ceremonyRepository;
    FuneralRepository funeralRepository;
    BurrialRepository burrialRepository;
    FlowerRepository flowerRepository;
    MealRepository mealRepository;

    @Override
    public List<Ceremony> retrieveAllCeremonies() {
        return (List<Ceremony>) ceremonyRepository.findAll();
    }

    @Override
    public Ceremony addCeremonie(Ceremony ceremony) {
        return ceremonyRepository.save(ceremony);
    }


    @Override
    public Ceremony updateCeremony(long id, Ceremony updatedCeremony) {
        // Trouver l'entité existante
        return ceremonyRepository.findById(id).map(ceremony -> {
            // Mettre à jour les champs de l'entité trouvée avec ceux de l'entité fournie
            ceremony.setDateFuneral(updatedCeremony.getDateFuneral());
            ceremony.setNbrInvite(updatedCeremony.getNbrInvite());
            ceremony.setFuneralLocations(updatedCeremony.getFuneralLocations());
            ceremony.setFlowers(updatedCeremony.getFlowers());
            ceremony.setMeals(updatedCeremony.getMeals());
            ceremony.setBurrialLocation(updatedCeremony.getBurrialLocation());
            ceremony.setUser(updatedCeremony.getUser());
            // Enregistrer l'entité mise à jour dans la base de données
            return ceremonyRepository.save(ceremony);
        }).orElseThrow(() -> new EntityNotFoundException("Ceremony not found with id " + id));
    }


    @Override
    public Ceremony retrieveCeremony(long idCeremony) {
        return ceremonyRepository.findById(idCeremony).orElse(null);
    }

    @Override
    public void removeCeremony(long idCeremony) {
        ceremonyRepository.deleteById(idCeremony);
    }



    @Transactional
    public Ceremony affecterBurrialLocationACeremony(long idCeremony, long idBurrial) {
        Ceremony ceremony = ceremonyRepository.findById(idCeremony).orElse(null);
        BurrialLocation burrialLocation = burrialRepository.findById(idBurrial).orElse(null);
        ceremony.setBurrialLocation(burrialLocation);
        return ceremonyRepository.save(ceremony);
    }

    @Transactional
    public Ceremony affecterFlowersACeremony(long idCeremony, long idFlower) {
        Ceremony ceremony = ceremonyRepository.findById(idCeremony).orElse(null);
        Flower flower = flowerRepository.findById(idFlower).orElse(null);

        if (ceremony != null && flower != null) {
            List<Flower> flowers = ceremony.getFlowers();
            if (flowers == null) {
                flowers = new ArrayList<>();
            }
            flowers.add(flower);
            ceremony.setFlowers(flowers);
        }
        return ceremonyRepository.save(ceremony);
    }

    @Transactional
    public Ceremony affecterMealsACeremony(long idCeremony, long idMeal) {
        Ceremony ceremony = ceremonyRepository.findById(idCeremony).orElse(null);
        Meal meal = mealRepository.findById(idMeal).orElse(null);

        if (ceremony != null && meal != null) {
            List<Meal> meals = ceremony.getMeals();
            if (meals == null) {
                meals = new ArrayList<>();
            }
            meals.add(meal);
            ceremony.setMeals(meals);
        }
        return ceremonyRepository.save(ceremony);
    }

    @Transactional
    public Ceremony affecterFuneralLocationsACeremony(long idCeremony, long idFuneral)  {
        Ceremony ceremony = ceremonyRepository.findById(idCeremony).orElse(null);
    FuneralLocation funeralLocation = funeralRepository.findById(idFuneral).orElse(null);

        if (ceremony != null && funeralLocation != null) {
        List<FuneralLocation> funeralLocations = ceremony.getFuneralLocations();
        if (funeralLocations == null) {
            funeralLocations = new ArrayList<>();
        }
        funeralLocations.add(funeralLocation);
        ceremony.setFuneralLocations(funeralLocations);
    }
        return ceremonyRepository.save(ceremony);
}






}
