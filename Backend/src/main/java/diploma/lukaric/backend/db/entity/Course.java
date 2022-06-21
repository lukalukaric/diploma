package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COURSE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double pride;

    private String place;

    @OneToMany(mappedBy = "course")
    private Collection<CourseOrganizer> courseOrganizer;

    @OneToMany(mappedBy = "course")
    private Collection<CourseStudent> courseStudent;
}
