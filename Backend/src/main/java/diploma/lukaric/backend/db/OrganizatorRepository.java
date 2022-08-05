package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.Organizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizatorRepository extends JpaRepository<Organizator, Long> {
}
