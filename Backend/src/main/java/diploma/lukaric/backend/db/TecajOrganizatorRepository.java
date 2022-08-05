package diploma.lukaric.backend.db;

import diploma.lukaric.backend.db.entity.TecajOrganizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecajOrganizatorRepository extends JpaRepository<TecajOrganizator, Long> {
}
