package hospital.db.demo.repository;

import hospital.db.demo.model.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternacaoRepository extends JpaRepository<Internacao, Integer> {}
