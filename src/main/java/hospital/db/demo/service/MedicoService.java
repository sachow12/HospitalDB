package hospital.db.demo.service;

import hospital.db.demo.model.Medico;
import hospital.db.demo.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeMedicos(int quantidade) {
        List<Medico> medicos = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Medico medico = new Medico();
            medico.setNome(faker.name().fullName());
            medico.setCpf(faker.idNumber().valid());
            medico.setCrm(faker.number().digits(6));
            medico.setEspecialidade(gerarEspecialidade());
            medico.setTelefone(faker.phoneNumber().phoneNumber());

            medicos.add(medico);
        }

        medicoRepository.saveAll(medicos);
    }

    private String gerarEspecialidade() {
        String[] especialidades = {"Cardiologia", "Pediatria", "Ortopedia", "Gastroenterologia", "Neurologia", "Dermatologia"};
        return especialidades[ThreadLocalRandom.current().nextInt(especialidades.length)];
    }
}
