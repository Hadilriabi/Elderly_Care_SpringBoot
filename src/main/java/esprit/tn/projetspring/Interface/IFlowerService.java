package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.Ceremony;
import esprit.tn.projetspring.Entity.Flower;
import esprit.tn.projetspring.Entity.FuneralLocation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFlowerService {
    List<Flower> retrieveAllFlowers( );
    Flower addFlower(Flower flower, MultipartFile file);
    Flower updatedFlower(Long idFlower, Flower updatedFlower, MultipartFile newImage);
    Flower retrieveFlower(long idFlower);

    void removeFlower(long idFlower);
}
