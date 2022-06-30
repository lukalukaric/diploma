package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.CourseOrganizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOrganizerRepository extends JpaRepository<CourseOrganizer, Long> {
}
