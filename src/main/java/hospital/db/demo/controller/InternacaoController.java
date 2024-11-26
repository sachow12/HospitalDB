package hospital.db.demo.controller;

import hospital.db.demo.service.InternacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internacao")
public class InternacaoController {

    @Autowired
    private InternacaoService internacaoService;

    @GetMapping("/inserirInternacoes")
    public String inserirInternacoes(@RequestParam(defaultValue = "500") int quantidade) {
        internacaoService.geradorDeInternacao(quantidade);
        return quantidade + " internações inseridas com sucesso!";
    }
}
