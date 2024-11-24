package hospital.db.demo.repository;

import hospital.db.demo.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}
