package esprit.tn.projetspring.Controller;



import esprit.tn.projetspring.Entity.Ceremony;
import esprit.tn.projetspring.Entity.Flower;

import esprit.tn.projetspring.Entity.FuneralLocation;
import esprit.tn.projetspring.Interface.IFlowerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/flowers")
public class FlowerController {
    IFlowerService flowerService;
    @PostMapping("/addFlower")
    public Flower addFlower(@ModelAttribute Flower flower,@RequestParam("image") MultipartFile file) {
        return flowerService.addFlower(flower,file);
    }




    @PutMapping("/updateFlower/{idFlower}")
    public Flower updatedFlower(
            @PathVariable("idFlower") Long idFlower,
            @ModelAttribute Flower updatedFlower,
            @RequestParam(value = "image", required = false) MultipartFile newImage) {

        return flowerService.updatedFlower(idFlower, updatedFlower, newImage);
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
