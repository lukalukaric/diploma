package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import java.util.Collection;

@Entity
@Table(name = "NASLOV")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Naslov {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ulica;

    private String hisnaStevilka;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_posta", nullable = false)
    private Posta posta;

    @OneToMany(mappedBy = "naslov")
    private Collection<Organizator> organizator;

    @OneToMany(mappedBy = "naslov")
    private Collection<Student> student;
}
