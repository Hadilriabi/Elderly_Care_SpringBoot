package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.Ceremony;
import esprit.tn.projetspring.Entity.FArrangement;

import java.util.List;

public interface IFArrangService {
    List<FArrangement> retrieveAllFArrangements();
    FArrangement addFArrangement(FArrangement fArrangement);
    FArrangement updateFArrangement(long idFArrangement,FArrangement fArrangement);
    FArrangement retrieveFArrangement(long idFArrangement);
    void removeFArrangement(long idFArrangement);
}
