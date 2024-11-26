package hospital.db.demo.service;

import hospital.db.demo.model.Paciente;
import hospital.db.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.time.ZoneId;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    Faker faker = new Faker();

    @Transactional
    public void geradorDePaciente(int quantidade){

        List<Paciente> pacientes = new ArrayList<>();
        for(int i = 0; i < quantidade; i++){
            LocalDate dataNascimento = gerarDataAleatoria();
            Date date = Date.from(dataNascimento.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Paciente paciente = new Paciente();
            paciente.setNome(faker.name().firstName());
            paciente.setCpf(faker.idNumber().valid());
            List<String> enderecos = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                enderecos.add(faker.address().fullAddress());
            }
            paciente.setEndereco(enderecos);
            paciente.setDataNascimento(date);
            List<String> telefones = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                telefones.add(faker.phoneNumber().phoneNumber());
            }
            paciente.setTelefone(telefones);
            List<String> contatosEmergencia = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                contatosEmergencia.add(faker.name().fullName() + " - " + faker.phoneNumber().phoneNumber());
            }
            paciente.setContatoEmergencia(contatosEmergencia);

            pacientes.add(paciente);


        }
        pacienteRepository.saveAll(pacientes);
    }

    private LocalDate gerarDataAleatoria() {
        int ano = ThreadLocalRandom.current().nextInt(1949, 2025);
        int mes = ThreadLocalRandom.current().nextInt(1, 13);
        int dia = ThreadLocalRandom.current().nextInt(1, 29);

        return LocalDate.of(ano, mes,dia);
}
}