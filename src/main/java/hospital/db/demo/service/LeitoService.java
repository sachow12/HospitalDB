package hospital.db.demo.service;

import hospital.db.demo.model.Leito;
import hospital.db.demo.repository.LeitoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeitoService {

    @Autowired
    private LeitoRepository leitoRepository;

    Faker faker = new Faker();

    @Transactional
    public void geradorDeLeito(int quantidade) {
        List<Leito> leitos = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Leito leito = new Leito();
            leito.setNumero(faker.number().numberBetween(1, 500));
            leito.setLocalizacao(faker.address().fullAddress());
            leito.setIsOcupado(false);

            leitos.add(leito);
        }

        leitoRepository.saveAll(leitos);
    }
}
