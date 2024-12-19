package esprit.tn.projetspring.Service;


import esprit.tn.projetspring.Entity.Flower;
import esprit.tn.projetspring.Entity.Meal;
import esprit.tn.projetspring.Interface.IMealService;
import esprit.tn.projetspring.Repository.MealRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MealService implements IMealService {
    MealRepository mealRepository;
    public static String uploadDirectory = "C:/xampp/htdocs/hadilprojet/";
    @Override
    public List<Meal> retrieveAllMeals() {
        return (List<Meal>) mealRepository.findAll();
    }


    @Override
    public Meal addMeal(Meal meal, MultipartFile file) {
        try {
            Path directoryPath = Paths.get(uploadDirectory);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            String originalFilename = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
            Path filePath = Paths.get(uploadDirectory, fileName);
            Files.write(filePath, file.getBytes());
            // Construire l'URL de l'image
            String imageUrl = fileName;
            // Définir l'URL de l'image sur l'objet FuneralLocation
            meal.setImgMeals(imageUrl);
            // Ajouter la FuneralLocation à la base de données
            return mealRepository.save(meal);
        } catch (IOException e) {
            log.error("Error occurred while adding funeral location:", e);
            return null; // Gérer l'erreur de manière appropriée dans votre application
        }
    }

    @Override
    public Meal updateMeal(Long idMeal, Meal updateMeal, MultipartFile newImage) {
        Meal meal = mealRepository.findById(idMeal)
                .orElseThrow(() -> new RuntimeException("Funeral location introuvable"));

        // Vérifier si une nouvelle image a été fournie
        if (newImage != null && !newImage.isEmpty()) {
            try {
                Path directoryPath = Paths.get(uploadDirectory);
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }
                String originalFilename = newImage.getOriginalFilename();
                String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
                Path newFilePath = Paths.get(uploadDirectory, fileName);
                Files.write(newFilePath, newImage.getBytes());

                // Mise à jour du nom de l'image avec le nouveau nom généré
                meal.setImgMeals(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error lors de la mise à jour de l'image");
            }
        }

        // Mise à jour des autres informations
        meal.setNameMeal(updateMeal.getNameMeal());
        meal.setPrixMeals(updateMeal.getPrixMeals());
        meal.setDescription(updateMeal.getDescription());


        // Enregistrer la mise à jour dans la base de données
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
