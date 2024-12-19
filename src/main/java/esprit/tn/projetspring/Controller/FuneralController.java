package esprit.tn.projetspring.Controller;


import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Entity.TypeReligion;
import esprit.tn.projetspring.Interface.IFuneralService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/funerals")
public class FuneralController {
  IFuneralService funeralService;

    @PostMapping("/addFuneralLocation")
    public FuneralLocation addFuneralLocation(@ModelAttribute FuneralLocation funeralLocation,@RequestParam("image") MultipartFile file) {
        return funeralService.addFuneralLocation(funeralLocation,file);
    }

    @PutMapping("/updateFuneralLocation/{idFunLoc}")
    public FuneralLocation updateFuneralLocation(
            @PathVariable("idFunLoc") Long idFunLoc,
            @ModelAttribute FuneralLocation updatedFuneralLocation,
            @RequestParam(value = "image", required = false) MultipartFile newImage) {

        return funeralService.updateFuneralLocation(idFunLoc, updatedFuneralLocation, newImage);
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

    @GetMapping("/ceremony/{ceremonyId}/funeralLocations")
    public ResponseEntity<List<FuneralLocation>> findFuneralLocationsByCeremonyId(@PathVariable Long ceremonyId) {
        List<FuneralLocation> funeralLocations = funeralService.findFuneralLocationsByCeremonyId(ceremonyId);
        if(funeralLocations != null) {
            return ResponseEntity.ok(funeralLocations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/funeralLocationsByReligion/{religion}")
    public ResponseEntity<List<FuneralLocation>> findFuneralLocationsByReligion(@PathVariable TypeReligion religion) {
        List<FuneralLocation> locations = funeralService.findFuneralLocationsByCeremonyReligion(religion);
        if(locations != null && !locations.isEmpty()) {
            return ResponseEntity.ok(locations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{funeralLocationId}/ceremony-dates")
    public List<LocalDate> getCeremonyDatesByFuneralLocationId(@PathVariable Long funeralLocationId) {
        return funeralService.findCeremonyDatesByFuneralLocationId(funeralLocationId);
    }
}
