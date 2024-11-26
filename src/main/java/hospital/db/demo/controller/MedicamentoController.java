package hospital.db.demo.controller;

import hospital.db.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/inserirMedicamentos")
    public String inserirMedicamentos(@RequestParam(defaultValue = "1000") int quantidade) {
        medicamentoService.geradorDeMedicamentos(quantidade);
        return quantidade + " medicamentos inseridos com sucesso!";
    }
}
