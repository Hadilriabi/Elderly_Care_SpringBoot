package esprit.tn.projetspring.Controller;


import esprit.tn.projetspring.Entity.FArrangement;
import esprit.tn.projetspring.Interface.IFArrangService;
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
@RequestMapping("api/farrangments")
public class FArrangController {

    IFArrangService ifArrangService;
    @PostMapping("/addFArrangement")
    public FArrangement addFArrangement(@RequestBody FArrangement fArrangement) {
        return ifArrangService.addFArrangement(fArrangement);
    }

    @PutMapping("/updateFArrangement/{idFArrangement}")
    public FArrangement updateFArrangement(@PathVariable("idFArrangement") long idFArrangement,@RequestBody FArrangement fArrangement) {
        return ifArrangService.updateFArrangement(idFArrangement,fArrangement);
    }

    @GetMapping("/retrieveFArrangement/{idFArrangement}")
    public  FArrangement retrieveFArrangement(@PathVariable("idFArrangement") long idFArrangement) {
        return ifArrangService.retrieveFArrangement(idFArrangement);
    }
    @DeleteMapping("/removeFArrangement/{idFArrangement}")
    public void removeFArrangement(@PathVariable("idFArrangement") long idFArrangement) {
        ifArrangService.removeFArrangement(idFArrangement);
    }
    @GetMapping("/retrieveAllFArrangements")
    public List<FArrangement> retrieveAllFArrangements() {
        return ifArrangService.retrieveAllFArrangements();
    }


}
