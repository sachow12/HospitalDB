package hospital.db.demo.controller;

import hospital.db.demo.service.ExamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExamesService examesService;

    @GetMapping("/inserirExames")
    public String inserirExames(@RequestParam(defaultValue = "2000") int quantidade) {
        examesService.geradorDeExames(quantidade);
        return quantidade + " exames inseridos com sucesso!";
    }
}
