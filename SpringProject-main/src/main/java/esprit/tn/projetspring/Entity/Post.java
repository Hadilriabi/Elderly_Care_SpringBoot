package esprit.tn.projetspring.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String descPost;
    private LocalDate dateCreation;
    private String imagePost;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private List<React> reacts;




}
