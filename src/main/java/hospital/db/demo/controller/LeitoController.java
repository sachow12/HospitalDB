package hospital.db.demo.controller;

import hospital.db.demo.service.LeitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leito")
public class LeitoController {

    @Autowired
    private LeitoService leitoService;

    @GetMapping("/inserirLeitos")
    public String inserirLeitos(@RequestParam(defaultValue = "300") int quantidade) {
        leitoService.geradorDeLeito(quantidade);
        return quantidade + " leitos inseridos com sucesso!";
    }
}
