package esprit.tn.projetspring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ceremony implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCer;
    LocalDate dateFuneral;
    int nbrInvite;

    @JsonIgnore

    @OneToOne
    private User user;


    @JsonIgnore

    @ManyToOne
    private FuneralLocation funeralLocation;

    @JsonIgnore

    @ManyToMany
    private List<Flower> flowers;

    @JsonIgnore

    @ManyToMany
    private List<Meal> meals;


    @JsonIgnore

    @ManyToOne
    private BurrialLocation burrialLocation;

}
