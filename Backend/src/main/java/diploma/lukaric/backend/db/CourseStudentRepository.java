package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.CourseStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, Long> {
}
