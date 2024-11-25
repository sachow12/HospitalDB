package hospital.db.demo.repository;

import hospital.db.demo.model.Enfermeira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermeiraRepository extends JpaRepository<Enfermeira, Integer> {}
