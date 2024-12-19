package esprit.tn.projetspring.Service;

import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Entity.Flower;
import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Interface.IFlowerService;
import esprit.tn.projetspring.Repository.FlowerRepository;
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
public class FlowerService implements IFlowerService {
    FlowerRepository flowerRepository;
    public static String uploadDirectory = "C:/xampp/htdocs/hadilprojet/";
    @Override
    public List<Flower> retrieveAllFlowers() {
        return (List<Flower>) flowerRepository.findAll();
    }

    @Override
    public Flower addFlower(Flower flower, MultipartFile file) {
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
            flower.setImgFlower(imageUrl);
            // Ajouter la FuneralLocation à la base de données
            return flowerRepository.save(flower);
        } catch (IOException e) {
            log.error("Error occurred while adding funeral location:", e);
            return null; // Gérer l'erreur de manière appropriée dans votre application
        }
    }

    @Override
    public Flower updatedFlower(Long idFlower, Flower updatedFlower, MultipartFile newImage) {
        Flower flower = flowerRepository.findById(idFlower)
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
                flower.setImgFlower(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error lors de la mise à jour de l'image");
            }
        }

        // Mise à jour des autres informations
        flower.setNomFlower(updatedFlower.getNomFlower());
        flower.setPrixFlower(updatedFlower.getPrixFlower());
        flower.setDescription(updatedFlower.getDescription());


        // Enregistrer la mise à jour dans la base de données
        return flowerRepository.save(flower);
    }

    @Override
    public Flower retrieveFlower(long idFlower) {
        return flowerRepository.findById(idFlower).orElse(null);
    }

    @Override
    public void removeFlower(long idFlower) {
        flowerRepository.deleteById(idFlower);
    }
}
