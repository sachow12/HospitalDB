package hospital.db.demo.repository;

import hospital.db.demo.model.Leito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitoRepository extends JpaRepository<Leito, Integer> {
}
