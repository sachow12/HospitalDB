package hospital.db.demo.controller;

import hospital.db.demo.service.CirurgiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cirurgia")
public class CirurgiaController {

    @Autowired
    private CirurgiaService cirurgiaService;

    @GetMapping("/inserirCirurgias")
    public String inserirCirurgias(@RequestParam(defaultValue = "500") int quantidade) {
        cirurgiaService.geradorDeCirurgias(quantidade);
        return quantidade + " cirurgias inseridas com sucesso!";
    }
}
