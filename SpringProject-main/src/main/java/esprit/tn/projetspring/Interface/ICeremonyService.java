package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Entity.Ceremony;
import esprit.tn.projetspring.Entity.FuneralLocation;

import java.util.List;

public interface ICeremonyService {
    List<Ceremony> retrieveAllCeremonies();
    Ceremony addCeremonie(Ceremony ceremony);
    Ceremony updateCeremony(Ceremony ceremony);
    Ceremony retrieveCeremony(long idCeremony);
    void removeCeremony(long idCeremony);

    Ceremony affecterFuneralLocationACeremony(long idCeremony, String nameLoc);
    Ceremony affecterBurrialLocationACeremony(long idCeremony, long idBurrial);

    Ceremony affecterFlowersACeremony(long idCeremony, String nomFlower);
    Ceremony affecterMealsACeremony(long idCeremony, String nomMeal);




}
