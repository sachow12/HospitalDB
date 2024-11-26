package hospital.db.demo.service;

import hospital.db.demo.model.Atendimento;
import hospital.db.demo.model.Cirurgia;
import hospital.db.demo.model.Enum.CirugiaGrauDeRisco;
import hospital.db.demo.model.Medico;
import hospital.db.demo.model.Paciente;
import hospital.db.demo.repository.CirurgiaRepository;
import jakarta.transaction.Transactional;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CirurgiaService {

    @Autowired
    private CirurgiaRepository cirurgiaRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeCirurgias(int quantidade) {

        List<Cirurgia> cirurgias = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Cirurgia cirurgia = new Cirurgia();
            cirurgia.setTipoCirurgia(gerarTipoCirurgia());
            cirurgia.setGrauDeRisco(gerarGrauDeRisco());

            cirurgias.add(cirurgia);
        }

        cirurgiaRepository.saveAll(cirurgias);
    }

    private String gerarTipoCirurgia() {
        String[] tiposCirurgia = {
                "Apêndice",
                "Cesárea",
                "Hérnia",
                "Cardíaca",
                "Ortopédica",
                "Plástica",
                "Ocular",
                "Vascular"
        };
        return tiposCirurgia[ThreadLocalRandom.current().nextInt(tiposCirurgia.length)];
    }

    private CirugiaGrauDeRisco gerarGrauDeRisco() {
        CirugiaGrauDeRisco[] grausDeRisco = CirugiaGrauDeRisco.values();
        return grausDeRisco[ThreadLocalRandom.current().nextInt(grausDeRisco.length)];
    }
}
