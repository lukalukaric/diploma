package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.Tecaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecajRepository extends JpaRepository<Tecaj, Long> {
}
