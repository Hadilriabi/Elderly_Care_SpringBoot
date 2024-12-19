package esprit.tn.projetspring.Interface;

import esprit.tn.projetspring.Entity.Ceremony;
import esprit.tn.projetspring.Entity.Flower;

import java.util.List;

public interface IFlowerService {
    List<Flower> retrieveAllFlowers( );
    Flower addFlower(Flower flower);
    Flower updateFlower(Flower flower);
    Flower retrieveFlower(long idFlower);

    void removeFlower(long idFlower);
}
