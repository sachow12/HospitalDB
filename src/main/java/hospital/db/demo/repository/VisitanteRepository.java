package hospital.db.demo.repository;

import hospital.db.demo.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitanteRepository extends JpaRepository<Visitante, Integer> {
}
