package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.BurrialLocation;

import java.util.List;

public interface IBurrialService {
    List<BurrialLocation> retrieveAllBerrial();
    BurrialLocation addBurrial(BurrialLocation burrialLocation);
    BurrialLocation updateBurrial(BurrialLocation burrialLocation);
    BurrialLocation retrieveBurrial(long idBurrial);
    void removeBurrial(Long idBurrial);


}
