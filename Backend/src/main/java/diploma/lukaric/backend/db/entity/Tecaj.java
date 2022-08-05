package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TECAJ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tecaj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;

    private Double cena;

    private String lokacija;

    @OneToMany(mappedBy = "tecaj")
    private Collection<TecajOrganizator> tecajOrganizator;

    @OneToMany(mappedBy = "tecaj")
    private Collection<TecajStudent> tecajStudent;
}
