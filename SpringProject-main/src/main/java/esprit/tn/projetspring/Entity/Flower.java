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
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long idFlower;
    String nomFlower;
    String imgFlower;
    float prixFlower;
    String description;


    @JsonIgnore

    @ManyToMany(mappedBy = "flowers")
    private List<Ceremony> ceremonies;
}
