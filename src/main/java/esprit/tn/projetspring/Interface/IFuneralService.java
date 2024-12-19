package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.Flower;
import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.TypeReligion;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IFuneralService {
    List<FuneralLocation> retrieveAllFuneralLocations( );
    public FuneralLocation addFuneralLocation(FuneralLocation funeralLocation, MultipartFile file);
    FuneralLocation updateFuneralLocation(Long idFunLoc, FuneralLocation updatedFuneralLocation,MultipartFile newImage);
    FuneralLocation retrieveFuneralLocation(long idFuneralLocation);

    void removeFuneralLocation(long idFuneralLocation);

    List<FuneralLocation> findFuneralLocationsByCeremonyId(Long ceremonyId);

    List<FuneralLocation> findFuneralLocationsByCeremonyReligion(TypeReligion religion);

    public List<LocalDate> findCeremonyDatesByFuneralLocationId(Long funeralLocationId);
}
