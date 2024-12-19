package esprit.tn.projetspring.Repository;


import esprit.tn.projetspring.Entity.FuneralLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuneralRepository extends CrudRepository<FuneralLocation,Long> {
    FuneralLocation findByNameLocLike(String nameLoc);
}
