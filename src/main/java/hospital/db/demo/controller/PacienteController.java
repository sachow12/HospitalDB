package hospital.db.demo.controller;

import hospital.db.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/inserirPacientes")
    public String inserirPaciente(@RequestParam(defaultValue = "10000") int quantidade ){
        pacienteService.geradorDePaciente(quantidade);
        return quantidade + " pacientes inseridos com sucesso!";
    }
}
