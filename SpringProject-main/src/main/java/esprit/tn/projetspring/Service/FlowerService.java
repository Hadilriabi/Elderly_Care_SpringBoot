package esprit.tn.projetspring.Service;

import esprit.tn.projetspring.Entity.Flower;
import esprit.tn.projetspring.Interface.IFlowerService;
import esprit.tn.projetspring.Repository.FlowerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlowerService implements IFlowerService {
    FlowerRepository flowerRepository;
    @Override
    public List<Flower> retrieveAllFlowers() {
        return (List<Flower>) flowerRepository.findAll();
    }

    @Override
    public Flower addFlower(Flower flower) {
        return flowerRepository.save(flower);
    }

    @Override
    public Flower updateFlower(Flower flower) {
        return flowerRepository.save(flower);
    }

    @Override
    public Flower retrieveFlower(long idFlower) {
        return flowerRepository.findById(idFlower).orElse(null);
    }

    @Override
    public void removeFlower(long idFlower) {
        flowerRepository.deleteById(idFlower);
    }
}
