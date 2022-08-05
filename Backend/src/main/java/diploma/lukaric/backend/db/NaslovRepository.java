package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.Naslov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaslovRepository extends JpaRepository<Naslov, Long> {
}
