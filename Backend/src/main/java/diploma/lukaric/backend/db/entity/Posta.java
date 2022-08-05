package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "POSTA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;

    private Integer postnaStevilka;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_drzava", nullable = false)
    private Drzava drzava;

    @OneToMany(mappedBy = "posta")
    private Collection<Naslov> naslov;
}
