package hospital.db.demo.controller;

import hospital.db.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/inserirMedicos")
    public String inserirMedicos(@RequestParam(defaultValue = "500") int quantidade) {
        medicoService.geradorDeMedicos(quantidade);
        return quantidade + " médicos inseridos com sucesso!";
    }
}
