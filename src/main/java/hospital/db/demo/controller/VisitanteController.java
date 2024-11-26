package hospital.db.demo.controller;

import hospital.db.demo.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping("/inserirVisitantes")
    public String inserirVisitantes(@RequestParam(defaultValue = "800") int quantidade) {
        visitanteService.geradorDeVisitantes(quantidade);
        return quantidade + " visitantes inseridos com sucesso!";
    }
}
