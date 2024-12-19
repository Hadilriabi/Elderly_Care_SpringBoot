package esprit.tn.projetspring.Repository;


import esprit.tn.projetspring.Entity.BurrialLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurrialRepository extends CrudRepository<BurrialLocation,Long> {
}
