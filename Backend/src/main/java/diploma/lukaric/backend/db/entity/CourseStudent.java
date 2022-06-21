package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COURSESTUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_course", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_student", nullable = false)
    private Student student;
}
