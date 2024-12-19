package esprit.tn.projetspring.Service;


import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Interface.IBurrialService;
import esprit.tn.projetspring.Repository.BurrialRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BurrialService implements IBurrialService {
    BurrialRepository burrialRepository;


    @Override
    public List<BurrialLocation> retrieveAllBerrial() {
        return (List<BurrialLocation>) burrialRepository.findAll() ;
    }


    public static String uploadDirectory = "C:/xampp/htdocs/hadilprojet/";
    @Override
    public BurrialLocation addBurrial(BurrialLocation burrialLocation,  MultipartFile file) {
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
            burrialLocation.setBurrialImg(imageUrl);
            // Ajouter la FuneralLocation à la base de données
            return burrialRepository.save(burrialLocation);
        } catch (IOException e) {
            log.error("Error occurred while adding funeral location:", e);
            return null; // Gérer l'erreur de manière appropriée dans votre application
        }
    }

    @Override
    public BurrialLocation updateBurrial(Long idBurrial,BurrialLocation updateBurrialLocation, MultipartFile newImage) {
        BurrialLocation burrialLocation = burrialRepository.findById(idBurrial)
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
                burrialLocation.setBurrialImg(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error lors de la mise à jour de l'image");
            }
        }

        // Mise à jour des autres informations
        burrialLocation.setBurrialName(updateBurrialLocation.getBurrialName());
        burrialLocation.setBurrialAdress(updateBurrialLocation.getBurrialAdress());


        // Enregistrer la mise à jour dans la base de données
        return burrialRepository.save(burrialLocation);
    }




    @Override
    public BurrialLocation retrieveBurrial(long idBurrial) {
        return burrialRepository.findById(idBurrial).orElse(null);
    }

    @Override
    public void removeBurrial(Long idBurrial) {
        burrialRepository.deleteById(idBurrial);

    }

    @Override
    public List<BurrialLocation> findBurrialLocationByCeremonyId(Long ceremonyId) {
        // Implémentez la logique pour trouver les emplacements funéraires par ID de cérémonie
        return burrialRepository.findBurrialLocationByCeremonyId(ceremonyId);
    }
}
