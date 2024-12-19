package esprit.tn.projetspring.Service;


import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.TypeLocation;
import esprit.tn.projetspring.Entity.TypeReligion;
import esprit.tn.projetspring.Interface.IFuneralService;
import esprit.tn.projetspring.Repository.FuneralRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuneralService implements IFuneralService {
    FuneralRepository funeralRepository;
    @Override
    public List<FuneralLocation> retrieveAllFuneralLocations() {
        return (List<FuneralLocation>) funeralRepository.findAll() ;
    }

    public static String uploadDirectory = "C:/xampp/htdocs/hadilprojet/";
    @Override
    public FuneralLocation addFuneralLocation( FuneralLocation funeralLocation,  MultipartFile file) {
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
            funeralLocation.setImgLoc(imageUrl);
            // Ajouter la FuneralLocation à la base de données
            return funeralRepository.save(funeralLocation);
        } catch (IOException e) {
            log.error("Error occurred while adding funeral location:", e);
            return null; // Gérer l'erreur de manière appropriée dans votre application
        }
    }

    // Méthode pour mettre à jour un emplacement funéraire
    public FuneralLocation updateFuneralLocation(Long idFunLoc, FuneralLocation updatedFuneralLocation, MultipartFile newImage) {
        FuneralLocation funeralLocation = funeralRepository.findById(idFunLoc)
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
                funeralLocation.setImgLoc(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error lors de la mise à jour de l'image");
            }
        }

        // Mise à jour des autres informations
        funeralLocation.setNameLoc(updatedFuneralLocation.getNameLoc());
        funeralLocation.setFuneralAdress(updatedFuneralLocation.getFuneralAdress());
        funeralLocation.setTypeLocation(updatedFuneralLocation.getTypeLocation());
        funeralLocation.setCapacityLoc(updatedFuneralLocation.getCapacityLoc());
        funeralLocation.setPriceLoc(updatedFuneralLocation.getPriceLoc());

        // Enregistrer la mise à jour dans la base de données
        return funeralRepository.save(funeralLocation);
    }


    // Les

    @Override
    public FuneralLocation retrieveFuneralLocation(long idFuneralLocation) {
        return funeralRepository.findById(idFuneralLocation).orElse(null);
    }

    @Override
    public void removeFuneralLocation(long idFuneralLocation) {
        funeralRepository.deleteById(idFuneralLocation);
    }



    // Nouvelle méthode pour récupérer les emplacements de funérailles par ID de cérémonie
    public List<FuneralLocation> findFuneralLocationsByCeremonyId(Long ceremonyId) {
        try {
            List<FuneralLocation> funeralLocations = funeralRepository.findFuneralLocationsByCeremonyId(ceremonyId);
            if (funeralLocations.isEmpty()) {
                log.info("Aucun emplacement de funérailles trouvé pour l'ID de cérémonie : {}", ceremonyId);
            }
            return funeralLocations;
        } catch (Exception e) {
            log.error("Erreur lors de la récupération des emplacements de funérailles pour l'ID de cérémonie : {}", ceremonyId, e);
            throw new RuntimeException("Erreur lors de la récupération des emplacements de funérailles", e);
        }
    }


    public List<FuneralLocation> findFuneralLocationsByCeremonyReligion(TypeReligion religion) {
        TypeLocation typeLocation;
        switch (religion) {
            case Muslim:
                typeLocation = TypeLocation.Mosquee;
                break;
            case Christian:
                typeLocation = TypeLocation.Church;
                break;
            case Jewish:
                typeLocation = TypeLocation.Synagogue;
                break;
            default:
                typeLocation = TypeLocation.Temple;
                break;
        }
        return funeralRepository.findFuneralLocationsByTypeLocation(typeLocation);
    }


    // Nouvelle méthode pour récupérer les dates des cérémonies associées à un emplacement de funérarium
    // Nouvelle méthode pour récupérer les dates des cérémonies associées à un emplacement de funérarium
    public List<LocalDate> findCeremonyDatesByFuneralLocationId(Long funeralLocationId) {
        try {
            List<LocalDate> ceremonyDates = funeralRepository.findCeremonyDatesByFuneralLocationId(funeralLocationId);
            if (ceremonyDates.isEmpty()) {
                log.info("Aucune date de cérémonie trouvée pour l'ID de l'emplacement de funérarium : {}", funeralLocationId);
            }
            return ceremonyDates;
        } catch (Exception e) {
            log.error("Erreur lors de la récupération des dates de cérémonie pour l'ID de l'emplacement de funérarium : {}", funeralLocationId, e);
            throw new RuntimeException("Erreur lors de la récupération des dates de cérémonie", e);
        }
    }



}
