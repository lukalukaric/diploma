package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.Drzava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Long> {
}
