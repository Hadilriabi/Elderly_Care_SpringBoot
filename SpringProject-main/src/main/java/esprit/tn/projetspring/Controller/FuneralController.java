package esprit.tn.projetspring.Controller;


import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Interface.IFuneralService;
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
@RequestMapping("api/funerals")
public class FuneralController {
  IFuneralService funeralService;

    @PostMapping("/addFuneralLocation")
    public FuneralLocation addFuneralLocation(@RequestBody FuneralLocation funeralLocation) {
        return funeralService.addFuneralLocation(funeralLocation);
    }

    @PutMapping("/updateFuneralLocation")
    public FuneralLocation updateFuneralLocation(@RequestBody FuneralLocation funeralLocation) {
        return funeralService.updateFuneralLocation(funeralLocation);
    }

    @GetMapping("/retrieveFuneralLocation/{idFuneralLocation}")
    public  FuneralLocation retrieveFuneralLocation(@PathVariable("idFuneralLocation") long idFuneralLocation) {
        return funeralService.retrieveFuneralLocation(idFuneralLocation);
    }
    @DeleteMapping("/removeFuneralLocation/{idFuneralLocation}")
    public void removeFuneralLocation(@PathVariable("idFuneralLocation") long idFuneralLocation) {
        funeralService.removeFuneralLocation(idFuneralLocation);
    }
    @GetMapping("/retrieveAllFuneralLocations")
    public List<FuneralLocation> retrieveAllFuneralLocations() {
        return funeralService.retrieveAllFuneralLocations();
    }
}
