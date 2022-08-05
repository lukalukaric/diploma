package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TECAJORGANIZATOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecajOrganizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_organizator", nullable = false)
    private Organizator organizator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_tecaj", nullable = false)
    private Tecaj tecaj;
}
