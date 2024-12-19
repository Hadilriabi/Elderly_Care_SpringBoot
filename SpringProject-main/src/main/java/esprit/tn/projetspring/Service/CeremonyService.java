package esprit.tn.projetspring.Service;

import esprit.tn.projetspring.Entity.*;
import esprit.tn.projetspring.Interface.ICeremonyService;
import esprit.tn.projetspring.Repository.*;
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
    public Ceremony updateCeremony(Ceremony ceremony) {
        return ceremonyRepository.save(ceremony);
    }

    @Override
    public Ceremony retrieveCeremony(long idCeremony) {
        return ceremonyRepository.findById(idCeremony).orElse(null);
    }

    @Override
    public void removeCeremony(long idCeremony) {
        ceremonyRepository.deleteById(idCeremony);
    }

    @Override
    public Ceremony affecterFuneralLocationACeremony(long idCeremony, String nameLoc) {
        FuneralLocation funeralLocation = funeralRepository.findByNameLocLike(nameLoc);
        Ceremony ceremony=ceremonyRepository.findById(idCeremony).orElse(null);
        ceremony.setFuneralLocation(funeralLocation);

        return ceremonyRepository.save(ceremony);
    }

    @Override
    public Ceremony affecterBurrialLocationACeremony(long idCeremony, long idBurrial) {
        Ceremony ceremony=ceremonyRepository.findById(idCeremony).orElse(null);
        BurrialLocation burrialLocation=burrialRepository.findById(idBurrial).orElse(null);
        ceremony.setBurrialLocation(burrialLocation);
        return ceremonyRepository.save(ceremony);
    }

    @Override
    public Ceremony affecterFlowersACeremony(long idCeremony, String nomFlower) {
        Ceremony ceremony=ceremonyRepository.findById(idCeremony).orElse(null);
        List<Flower> flowers= flowerRepository.findByNomFlowerLike(nomFlower);

        ceremony.setFlowers(flowers);
        return ceremonyRepository.save(ceremony);

    }

    @Override
    public Ceremony affecterMealsACeremony(long idCeremony, String nomMeal) {
        Ceremony ceremony=ceremonyRepository.findById(idCeremony).orElse(null);
        List<Meal> meals= mealRepository.findByNameMealLike(nomMeal);

        ceremony.setMeals(meals);
        return ceremonyRepository.save(ceremony);
    }
}
