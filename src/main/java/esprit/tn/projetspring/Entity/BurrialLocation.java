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
public class BurrialLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long idBurrial;
    String BurrialName;
    String BurrialAdress;
    String BurrialImg;

    @JsonIgnore
    @OneToMany(mappedBy = "burrialLocation")
    private List<Ceremony> ceremonies;


}
