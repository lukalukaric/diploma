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

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_address", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "student")
    private Collection<CourseStudent> courseStudent;
}
