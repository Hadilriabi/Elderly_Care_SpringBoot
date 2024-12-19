package esprit.tn.projetspring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuneralLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idLoc;
    String nameLoc;
    String imgLoc;
    float priceLoc;
    int capacityLoc;
    @Enumerated(EnumType.STRING)
    TypeLocation typeLocation;
    String funeralAdress;


    @JsonIgnore

    @ManyToMany(mappedBy = "funeralLocations")
    private List<Ceremony> ceremonies;

}
