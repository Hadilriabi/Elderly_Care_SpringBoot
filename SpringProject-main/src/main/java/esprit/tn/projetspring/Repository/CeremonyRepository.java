package esprit.tn.projetspring.Repository;

import esprit.tn.projetspring.Entity.Ceremony;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CeremonyRepository extends CrudRepository<Ceremony,Long> {
}
