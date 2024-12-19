package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.BurrialLocation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IBurrialService {
    List<BurrialLocation> retrieveAllBerrial();
    BurrialLocation addBurrial(BurrialLocation burrialLocation,  MultipartFile file);
    BurrialLocation updateBurrial(Long idBurrial,BurrialLocation updateBurrialLocation, MultipartFile newImage);
    BurrialLocation retrieveBurrial(long idBurrial);
    void removeBurrial(Long idBurrial);
    List<BurrialLocation> findBurrialLocationByCeremonyId(Long ceremonyId);


}
