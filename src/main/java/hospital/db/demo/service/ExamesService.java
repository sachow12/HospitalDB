package hospital.db.demo.service;

import hospital.db.demo.model.Atendimento;
import hospital.db.demo.model.Enum.ExamesStatus;
import hospital.db.demo.model.Exames;
import hospital.db.demo.repository.ExamesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ExamesService {

    @Autowired
    private ExamesRepository examesRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeExames(int quantidade) {


        List<Exames> examesList = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Exames exame = new Exames();
            exame.setRealizacao(gerarDataAleatoria());
            exame.setStatusExame(gerarStatusExame());
            exame.setResultados(gerarResultados());

            examesList.add(exame);
        }

        examesRepository.saveAll(examesList);
    }

    private Date gerarDataAleatoria() {
        long agora = System.currentTimeMillis();
        long dataAleatoria = ThreadLocalRandom.current().nextLong(agora - 31556952000L, agora); // Último ano
        return new Date(dataAleatoria);
    }

    private ExamesStatus gerarStatusExame() {
        ExamesStatus[] status = ExamesStatus.values();
        return status[ThreadLocalRandom.current().nextInt(status.length)];
    }

    private List<String> gerarResultados() {
        String[] resultadosPossiveis = {"Negativo", "Positivo", "Indeterminado", "Em análise"};
        List<String> resultados = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1, 4); i++) {
            resultados.add(resultadosPossiveis[ThreadLocalRandom.current().nextInt(resultadosPossiveis.length)]);
        }
        return resultados;
    }
}
