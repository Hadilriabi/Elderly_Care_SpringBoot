package esprit.tn.projetspring.Controller;



import esprit.tn.projetspring.Entity.Ceremony;
import esprit.tn.projetspring.Entity.Flower;

import esprit.tn.projetspring.Interface.IFlowerService;
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
@RequestMapping("api/flowers")
public class FlowerController {
    IFlowerService flowerService;
    @PostMapping("/addFlower")
    public Flower addFlower(@RequestBody Flower flower) {
        return flowerService.addFlower(flower);
    }

    @PutMapping("/updateFlower")
    public Flower updateFlower(@RequestBody Flower flower) {
        return flowerService.updateFlower(flower);
    }

    @GetMapping("/retrieveFlower/{idFlower}")
    public  Flower retrieveFlower(@PathVariable("idFlower") long idFlower) {
        return flowerService.retrieveFlower(idFlower);
    }
    @DeleteMapping("/removeFlower/{idFlower}")
    public void removeFlower(@PathVariable("idFlower") long idFlower) {
        flowerService.removeFlower(idFlower);
    }

    @GetMapping("/retrieveAllFlowers")
    public List<Flower> retrieveAllFlowers() {
        return flowerService.retrieveAllFlowers();
    }
}
