package hospital.db.demo.service;

import hospital.db.demo.model.Atendimento;
import hospital.db.demo.model.Medico;
import hospital.db.demo.model.Paciente;
import hospital.db.demo.repository.AtendimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Transactional
    public void geradorDeAtendimento(int quantidade) {
        List<Atendimento> atendimentos = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Atendimento atendimento = new Atendimento();
            atendimento.setDataAtendimento(gerarDataAleatoria());
            atendimento.setMotivo(gerarMotivo());
            atendimento.setDiagnostico(gerarDiagnostico());
            atendimento.setRecomendacao(gerarRecomendacao());
            atendimento.setTipoAtendimento(gerarTipoAtendimento());

            atendimentos.add(atendimento);
        }

        atendimentoRepository.saveAll(atendimentos);
    }

    private Date gerarDataAleatoria() {
        LocalDateTime dataAleatoria = LocalDateTime.of(
                ThreadLocalRandom.current().nextInt(2020, 2025),
                ThreadLocalRandom.current().nextInt(1, 13),
                ThreadLocalRandom.current().nextInt(1, 29),
                ThreadLocalRandom.current().nextInt(0, 24),
                ThreadLocalRandom.current().nextInt(0, 60)
        );

        return Date.from(dataAleatoria.atZone(ZoneId.systemDefault()).toInstant());
    }

    private String gerarMotivo() {
        String[] motivos = {"check-up", "cirurgia", "exames", "emergência"};
        return motivos[ThreadLocalRandom.current().nextInt(motivos.length)];
    }

    private String gerarDiagnostico() {
        String[] diagnosticos = {"febre", "cansaço", "gripe", "tuberculose", "HIV", "monkeypox"};
        return diagnosticos[ThreadLocalRandom.current().nextInt(diagnosticos.length)];
    }

    private String gerarRecomendacao() {
        String[] recomendacoes = {"descansar", "cirurgia", "UTI", "amputação", "remédios", "internação"};
        return recomendacoes[ThreadLocalRandom.current().nextInt(recomendacoes.length)];
    }

    private String gerarTipoAtendimento() {
        String[] tipos = {"Consulta", "Emergência", "Rotina", "Retorno"};
        return tipos[ThreadLocalRandom.current().nextInt(tipos.length)];
    }
}


