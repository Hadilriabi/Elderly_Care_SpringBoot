package esprit.tn.projetspring.Service;

import esprit.tn.projetspring.Entity.Ceremony;
import esprit.tn.projetspring.Entity.FArrangement;
import esprit.tn.projetspring.Interface.IFArrangService;
import esprit.tn.projetspring.Repository.FArrangRepo;
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
public class FArrangService implements IFArrangService {
    FArrangRepo fArrangRepo;
    @Override
    public List<FArrangement> retrieveAllFArrangements() {
        return (List<FArrangement>) fArrangRepo.findAll();

    }

    @Override
    public FArrangement addFArrangement(FArrangement fArrangement) {
        return fArrangRepo.save(fArrangement);
    }

    @Override
    public FArrangement updateFArrangement(long idFArrangement, FArrangement fArrangement) {
        FArrangement existingFArrangement = fArrangRepo.findById(idFArrangement).orElse(null);
        if (existingFArrangement != null) {
            fArrangement.setIdArrangement(idFArrangement);
            return fArrangRepo.save(fArrangement);
        }
        return null;
    }

    @Override
    public FArrangement retrieveFArrangement(long idFArrangement) {
        return fArrangRepo.findById(idFArrangement).orElse(null);
    }

    @Override
    public void removeFArrangement(long idFArrangement) {
        fArrangRepo.deleteById(idFArrangement);

    }
}
