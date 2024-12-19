package esprit.tn.projetspring.Controller;


import esprit.tn.projetspring.Entity.BurrialLocation;
import esprit.tn.projetspring.Entity.Ceremony;

import esprit.tn.projetspring.Interface.ICeremonyService;
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
@RequestMapping("api/ceremonies")
public class CeremonyController {

    ICeremonyService ceremonyService;
    @PostMapping("/addCeremony")
    public Ceremony addBurrialLocation(@RequestBody Ceremony ceremony) {
        return ceremonyService.addCeremonie(ceremony);
    }

    @PutMapping("/updateCeremony")
    public Ceremony updateCeremony(@RequestBody Ceremony ceremony) {
        return ceremonyService.updateCeremony(ceremony);
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


}
