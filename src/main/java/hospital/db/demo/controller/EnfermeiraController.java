package hospital.db.demo.controller;

import hospital.db.demo.service.EnfermeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enfermeira")
public class EnfermeiraController {

    @Autowired
    private EnfermeiraService enfermeiraService;

    @GetMapping("/inserirEnfermeiras")
    public String inserirEnfermeiras(@RequestParam(defaultValue = "500") int quantidade) {
        enfermeiraService.geradorDeEnfermeira(quantidade);
        return quantidade + " enfermeiras inseridas com sucesso!";
    }
}
