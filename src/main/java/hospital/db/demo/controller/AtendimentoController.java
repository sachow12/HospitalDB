package hospital.db.demo.controller;

import hospital.db.demo.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping("/inserirAtendimentos")
    public String inserirAtendimentos(@RequestParam(defaultValue = "10000") int quantidade) {
        atendimentoService.geradorDeAtendimento(quantidade);
        return quantidade + " atendimentos inseridos com sucesso!";
    }
}
