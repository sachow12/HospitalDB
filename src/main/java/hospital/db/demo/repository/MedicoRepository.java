package hospital.db.demo.repository;

import hospital.db.demo.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {}
