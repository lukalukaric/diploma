package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import java.util.Collection;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String houseNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_mail", nullable = false)
    private Mail mail;

    @OneToMany(mappedBy = "address")
    private Collection<Organizer> organizer;

    @OneToMany(mappedBy = "address")
    private Collection<Student> student;
}
