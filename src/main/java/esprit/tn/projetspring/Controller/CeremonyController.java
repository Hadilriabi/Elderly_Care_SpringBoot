package esprit.tn.projetspring.Controller;


import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Entity.Ceremony;

import esprit.tn.projetspring.Interface.ICeremonyService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/ceremonies")
public class CeremonyController {

    ICeremonyService ceremonyService;
    @PostMapping("/addCeremony")
    public Ceremony addBurrialLocation(@RequestBody Ceremony ceremony) {
        return ceremonyService.addCeremonie(ceremony);
    }

    @PutMapping("/updateCeremony/{idCeremony}")
    public Ceremony updateCeremony(@PathVariable("idCeremony") long idCeremony,@RequestBody Ceremony ceremony) {
        return ceremonyService.updateCeremony(idCeremony,ceremony);
    }

    @GetMapping("/retrieveCeremony/{idCeremony}")
    public  Ceremony retrieveCeremony(@PathVariable("idCeremony") long idCeremony) {
        return ceremonyService.retrieveCeremony(idCeremony);
    }
    @DeleteMapping("/removeCeremony/{idCeremony}")
    public void removeCeremony(@PathVariable("idCeremony") long idCeremony) {
        ceremonyService.removeCeremony(idCeremony);
    }
    @GetMapping("/retrieveAllCeremonies")
    public List<Ceremony> retrieveAllCeremonies() {
        return ceremonyService.retrieveAllCeremonies();
    }




    @PostMapping("/{idCeremony}/burrialLocation/{idBurrial}")
    public Ceremony affecterBurrialLocationACeremony(@PathVariable long idCeremony, @PathVariable long idBurrial) {
        return ceremonyService.affecterBurrialLocationACeremony(idCeremony, idBurrial);
    }

    @PostMapping("/{idCeremony}/flowers/{idFlower}")
    public Ceremony affecterFlowersACeremony(@PathVariable long idCeremony, @PathVariable long idFlower) {
        return ceremonyService.affecterFlowersACeremony(idCeremony, idFlower);
    }

    @PostMapping("/{idCeremony}/meals/{idMeal}")
    public Ceremony affecterMealsACeremony(@PathVariable long idCeremony, @PathVariable long idMeal) {
        return ceremonyService.affecterMealsACeremony(idCeremony, idMeal);
    }


    @PostMapping("/{idCeremony}/funerals/{idFuneral}")
    public Ceremony affecterFuneralLocationsACeremony(@PathVariable long idCeremony, @PathVariable long idFuneral) {
        return ceremonyService.affecterFuneralLocationsACeremony(idCeremony, idFuneral);
    }




}
