package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.TecajStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecajStudentRepository extends JpaRepository<TecajStudent, Long> {
}
