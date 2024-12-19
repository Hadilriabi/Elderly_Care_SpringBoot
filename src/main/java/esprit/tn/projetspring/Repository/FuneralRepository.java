package esprit.tn.projetspring.Repository;


import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.TypeLocation;
import esprit.tn.projetspring.Entity.TypeReligion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface FuneralRepository extends CrudRepository<FuneralLocation,Long> {
    FuneralLocation findByNameLocLike(String nameLoc);

    // Requête JPQL pour récupérer les FuneralLocation associés à un ID de Ceremony
    @Query("SELECT fl FROM FuneralLocation fl JOIN fl.ceremonies c WHERE c.idCer = :ceremonyId")
    List<FuneralLocation> findFuneralLocationsByCeremonyId(@Param("ceremonyId") Long ceremonyId);

    @Query("SELECT fl FROM FuneralLocation fl WHERE fl.typeLocation = :typeLocation")
    List<FuneralLocation> findFuneralLocationsByTypeLocation(@Param("typeLocation") TypeLocation typeLocation);

    // Requête JPQL pour récupérer les dates des cérémonies associées à un emplacement de funérarium spécifique
    @Query("SELECT c.dateFuneral FROM Ceremony c JOIN c.funeralLocations fl WHERE fl.idLoc = :funeralLocationId")
    List<LocalDate> findCeremonyDatesByFuneralLocationId(@Param("funeralLocationId") Long funeralLocationId);

}

