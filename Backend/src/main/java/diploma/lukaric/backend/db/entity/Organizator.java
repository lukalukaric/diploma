package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ORGANIZATOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_naslov", nullable = false)
    private Naslov naslov;

    @OneToMany(mappedBy = "organizator")
    private Collection<TecajOrganizator> tecajOrganizator;
}
