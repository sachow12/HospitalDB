package hospital.db.demo.service;

import hospital.db.demo.model.Atendimento;
import hospital.db.demo.model.Paciente;
import hospital.db.demo.model.Visitante;
import hospital.db.demo.repository.VisitanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository visitanteRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeVisitantes(int quantidade) {


        List<Visitante> visitantes = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Visitante visitante = new Visitante();
            visitante.setNome(faker.name().fullName());
            visitante.setParentesco(gerarParentesco());
            visitante.setPeriodoVisita(gerarDataVisita());
            visitante.setTelefone(faker.phoneNumber().phoneNumber());

            visitantes.add(visitante);
        }

        visitanteRepository.saveAll(visitantes);
    }

    private String gerarParentesco() {
        String[] parentescos = {"Mãe", "Pai", "Irmão", "Cônjuge", "Amigo", "Filho"};
        return parentescos[ThreadLocalRandom.current().nextInt(parentescos.length)];
    }

    private Date gerarDataVisita() {
        long agora = System.currentTimeMillis();
        long visitaAleatoria = ThreadLocalRandom.current().nextLong(agora - 2592000000L, agora); // Últimos 30 dias
        return new Date(visitaAleatoria);
    }
}
