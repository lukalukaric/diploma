package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "MAIL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer postcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_state", nullable = false)
    private State state;

    @OneToMany(mappedBy = "mail")
    private Collection<Address> address;
}
