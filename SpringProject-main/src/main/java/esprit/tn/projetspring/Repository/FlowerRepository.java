package esprit.tn.projetspring.Repository;


import esprit.tn.projetspring.Entity.Flower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerRepository extends CrudRepository<Flower,Long> {
    List<Flower> findByNomFlowerLike(String flowerName);
}
