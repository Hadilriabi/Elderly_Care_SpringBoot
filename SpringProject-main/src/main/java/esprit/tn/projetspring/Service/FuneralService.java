package esprit.tn.projetspring.Service;


import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Interface.IFuneralService;
import esprit.tn.projetspring.Repository.FuneralRepository;
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
public class FuneralService implements IFuneralService {
    FuneralRepository funeralRepository;
    @Override
    public List<FuneralLocation> retrieveAllFuneralLocations() {
        return (List<FuneralLocation>) funeralRepository.findAll() ;
    }

    @Override
    public FuneralLocation addFuneralLocation(FuneralLocation funeralLocation) {
        return funeralRepository.save(funeralLocation);
    }

    @Override
    public FuneralLocation updateFuneralLocation(FuneralLocation funeralLocation) {
        return funeralRepository.save(funeralLocation);
    }

    @Override
    public FuneralLocation retrieveFuneralLocation(long idFuneralLocation) {
        return funeralRepository.findById(idFuneralLocation).orElse(null);
    }

    @Override
    public void removeFuneralLocation(long idFuneralLocation) {
        funeralRepository.deleteById(idFuneralLocation);
    }
}
