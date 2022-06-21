package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ORGANIZER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_address", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "organizer")
    private Collection<CourseOrganizer> courseOrganizer;
}
