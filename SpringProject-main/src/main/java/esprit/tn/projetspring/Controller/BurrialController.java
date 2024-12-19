package esprit.tn.projetspring.Controller;
import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Interface.IBurrialService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/burrials")
public class BurrialController {
    IBurrialService burrialService;
    @PostMapping("/addBurrialLocation")
    public BurrialLocation addBurrialLocation(@RequestBody BurrialLocation burrialLocation) {
        return burrialService.addBurrial(burrialLocation);
    }

    @PutMapping("/updateBurrialLocation")
    public BurrialLocation updateBurrialLocation(@RequestBody BurrialLocation burrialLocation) {
        return burrialService.updateBurrial(burrialLocation);
    }

    @GetMapping("/retrieveBurrialLocation/{idBurrialLocation}")
    public  BurrialLocation retrieveBurrialLocation(@PathVariable("idBurrialLocation") long idBurrialLocation) {
        return burrialService.retrieveBurrial(idBurrialLocation);
    }
    @DeleteMapping("/removeBurrialLocation/{idBurrialLocation}")
    public void removeEtudiant(@PathVariable("idBurrialLocation") long idBurrialLocation) {
        burrialService.removeBurrial(idBurrialLocation);
    }

    @GetMapping("/retrieveAllBurrialLocations")
    public List<BurrialLocation> retrieveAllBurrialLocations() {
        return burrialService.retrieveAllBerrial();
    }

}
