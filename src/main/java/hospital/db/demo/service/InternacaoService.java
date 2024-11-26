package hospital.db.demo.service;

import hospital.db.demo.model.Enfermeira;
import hospital.db.demo.model.Internacao;
import hospital.db.demo.model.Leito;
import hospital.db.demo.model.Paciente;
import hospital.db.demo.repository.InternacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class InternacaoService {

    @Autowired
    private InternacaoRepository internacaoRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeInternacao(int quantidade) {


        List<Internacao> internacoes = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {


            Internacao internacao = new Internacao();
            internacao.setDataInternacao(gerarDataAleatoria());
            internacao.setDataAlta(gerarDataAlta(internacao.getDataInternacao()));
            internacao.setMotivo(gerarMotivo());
            internacoes.add(internacao);
        }

        internacaoRepository.saveAll(internacoes);
    }

    private Date gerarDataAleatoria() {
        long agora = System.currentTimeMillis();
        long aleatorio = ThreadLocalRandom.current().nextLong(agora - 31536000000L, agora); // Último ano
        return new Date(aleatorio);
    }

    private Date gerarDataAlta(Date dataInternacao) {
        long umDia = 86400000L; // Um dia em milissegundos
        long altaAleatoria = dataInternacao.getTime() + ThreadLocalRandom.current().nextLong(umDia, umDia * 15); // 1 a 15 dias
        return new Date(altaAleatoria);
    }

    private String gerarMotivo() {
        String[] motivos = {"Emergência", "Cirurgia", "Observação", "Tratamento prolongado"};
        return motivos[ThreadLocalRandom.current().nextInt(motivos.length)];
    }
}
