package hospital.db.demo.service;

import hospital.db.demo.model.Enfermeira;
import hospital.db.demo.model.Paciente;
import hospital.db.demo.repository.EnfermeiraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EnfermeiraService {

    @Autowired
    private EnfermeiraRepository enfermeiraRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeEnfermeira(int quantidade) {


        List<Enfermeira> enfermeiras = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Enfermeira enfermeira = new Enfermeira();
            enfermeira.setNome(faker.name().fullName());
            enfermeira.setCpf(faker.idNumber().valid());
            enfermeira.setCip(faker.number().digits(5));
            enfermeiras.add(enfermeira);
        }

        enfermeiraRepository.saveAll(enfermeiras);
    }


}