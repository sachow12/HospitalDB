package hospital.db.demo.repository;

import hospital.db.demo.model.Exames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamesRepository extends JpaRepository<Exames, Integer> {}
