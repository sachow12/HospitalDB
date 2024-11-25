package hospital.db.demo.repository;

import hospital.db.demo.model.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CirurgiaRepository extends JpaRepository<Cirurgia, Integer> {}
