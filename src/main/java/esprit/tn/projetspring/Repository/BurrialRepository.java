package esprit.tn.projetspring.Repository;


import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Entity.FuneralLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BurrialRepository extends CrudRepository<BurrialLocation,Long> {
    @Query("SELECT b FROM BurrialLocation b JOIN b.ceremonies c WHERE c.idCer = :ceremonyId")
    List<BurrialLocation> findBurrialLocationByCeremonyId(@Param("ceremonyId") Long ceremonyId);

}
