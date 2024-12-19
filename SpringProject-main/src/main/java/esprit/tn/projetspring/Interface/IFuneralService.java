package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.Flower;
import esprit.tn.projetspring.Entity.FuneralLocation;

import java.util.List;

public interface IFuneralService {
    List<FuneralLocation> retrieveAllFuneralLocations( );
    FuneralLocation addFuneralLocation(FuneralLocation funeralLocation);
    FuneralLocation updateFuneralLocation(FuneralLocation funeralLocation);
    FuneralLocation retrieveFuneralLocation(long idFuneralLocation);

    void removeFuneralLocation(long idFuneralLocation);
}
