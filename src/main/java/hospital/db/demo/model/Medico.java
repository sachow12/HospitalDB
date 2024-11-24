package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cpf;

    private String crm;

    private String especialidade;

    private String telefone;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Cirurgia> cirurgias;
}
