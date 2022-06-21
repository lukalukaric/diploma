package diploma.lukaric.backend.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COURSEORGANIZER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseOrganizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_organizer", nullable = false)
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_course", nullable = false)
    private Course course;
}
