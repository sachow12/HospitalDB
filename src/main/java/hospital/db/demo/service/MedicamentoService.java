package hospital.db.demo.service;

import hospital.db.demo.model.Atendimento;
import hospital.db.demo.model.Enfermeira;
import hospital.db.demo.model.Medicamento;
import hospital.db.demo.repository.MedicamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeMedicamentos(int quantidade) {


        List<Medicamento> medicamentos = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Medicamento medicamento = new Medicamento();
            medicamento.setNome(gerarNomeMedicamento());
            medicamento.setValidade(gerarDataValidade());
            medicamento.setLote(faker.number().randomNumber(8, true));
            medicamento.setFabricante(faker.company().name());

            medicamentos.add(medicamento);
        }

        medicamentoRepository.saveAll(medicamentos);
    }

    private Date gerarDataValidade() {
        long agora = System.currentTimeMillis();
        long validadeAleatoria = ThreadLocalRandom.current().nextLong(agora, agora + 31536000000L * 2); // Próximos 2 anos
        return new Date(validadeAleatoria);
    }

    private String gerarNomeMedicamento() {
        String[] medicamentosPossiveis = {"Paracetamol", "Ibuprofeno", "Amoxicilina", "Omeprazol", "Dipirona", "Cefalexina"};
        return medicamentosPossiveis[ThreadLocalRandom.current().nextInt(medicamentosPossiveis.length)];
    }
}
