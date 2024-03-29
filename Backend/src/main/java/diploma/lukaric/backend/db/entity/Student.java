package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;

    private String priimek;

    private String telefonskaStevilka;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_naslov", nullable = false)
    private Naslov naslov;

    @OneToMany(mappedBy = "student")
    private Collection<TecajStudent> tecajStudent;
}
