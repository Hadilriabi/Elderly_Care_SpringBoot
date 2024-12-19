package esprit.tn.projetspring.Controller;
import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Interface.IBurrialService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/burrials")
public class BurrialController {
    IBurrialService burrialService;
    @PostMapping("/addBurrialLocation")
    public BurrialLocation addBurrialLocation(@ModelAttribute BurrialLocation burrialLocation,@RequestParam("image") MultipartFile file) {
        return burrialService.addBurrial(burrialLocation,file);
    }

    @PutMapping("/updateBurrialLocation/{idBurrial}")
    public BurrialLocation updateBurrialLocation(@PathVariable("idBurrial") Long idBurrial, @ModelAttribute BurrialLocation updateBurrialLocation, @RequestParam(value = "image", required = false) MultipartFile newImage) {
        return burrialService.updateBurrial(idBurrial,updateBurrialLocation,newImage);
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


    @GetMapping("/ceremony/{ceremonyId}/burrialLocations")
    public ResponseEntity<List<BurrialLocation>> findBurrialLocationsByCeremonyId(@PathVariable Long ceremonyId) {
        List<BurrialLocation> burrialLocations = burrialService.findBurrialLocationByCeremonyId(ceremonyId);
        if(burrialLocations != null) {
            return ResponseEntity.ok(burrialLocations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
