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
    String nom;
    String prenom;
    @Enumerated(EnumType.STRING)
    TypeReligion religion;

    @JsonIgnore

    @OneToOne
    private User user;





    @ManyToMany
    private List<FuneralLocation> funeralLocations;



    @ManyToMany
    private List<Flower> flowers;



    @ManyToMany
    private List<Meal> meals;




    @ManyToOne
    private BurrialLocation burrialLocation;

    @JsonIgnore
    @OneToOne
    private FArrangement fArrangement;



}
