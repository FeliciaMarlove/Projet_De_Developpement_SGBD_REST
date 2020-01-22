package be.iramps.florencemary.devsgbd.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ville", schema = "public", catalog = "brico")
public class Ville implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ville_generator")
    @SequenceGenerator(name = "ville_generator", allocationSize = 1, initialValue = 1)
    @Column(name = "id_ville")
    private Long idVille;

    @Column(name = "nom_ville")
    private String nomVille;
}
