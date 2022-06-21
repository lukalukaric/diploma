package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.CourseOrganizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseOrganizerRepository extends JpaRepository<CourseOrganizer, Long> {
}
