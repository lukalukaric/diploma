package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TECAJSTUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecajStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_tecaj", nullable = false)
    private Tecaj tecaj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TK_student", nullable = false)
    private Student student;
}
