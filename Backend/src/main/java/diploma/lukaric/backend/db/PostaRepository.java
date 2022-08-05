package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.Posta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostaRepository extends JpaRepository<Posta, Long> {
}
