package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DRZAVA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drzava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;

    @OneToMany(mappedBy = "drzava")
    private Collection<Posta> posta;
}
