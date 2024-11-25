package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "crm")
    private String crm;
    @Column(name = "especialidade")
    private String especialidade;
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Cirurgia> cirurgias;
}
