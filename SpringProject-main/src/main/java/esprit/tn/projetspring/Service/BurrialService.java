package esprit.tn.projetspring.Service;


import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Interface.IBurrialService;
import esprit.tn.projetspring.Repository.BurrialRepository;
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
public class BurrialService implements IBurrialService {
    BurrialRepository burrialRepository;


    @Override
    public List<BurrialLocation> retrieveAllBerrial() {
        return (List<BurrialLocation>) burrialRepository.findAll() ;
    }

    @Override
    public BurrialLocation addBurrial(BurrialLocation burrialLocation) {
        return burrialRepository.save(burrialLocation);
    }

    @Override
    public BurrialLocation updateBurrial(BurrialLocation burrialLocation) {
        return burrialRepository.save(burrialLocation);
    }

    @Override
    public BurrialLocation retrieveBurrial(long idBurrial) {
        return burrialRepository.findById(idBurrial).orElse(null);
    }

    @Override
    public void removeBurrial(Long idBurrial) {
        burrialRepository.deleteById(idBurrial);

    }
}
