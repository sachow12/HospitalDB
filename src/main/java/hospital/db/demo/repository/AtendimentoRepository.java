package hospital.db.demo.repository;

import hospital.db.demo.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
}
