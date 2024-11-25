package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enfermeira")
public class Enfermeira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfermeira")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @OneToMany(mappedBy = "enfermeira")
    private List<Medicamento> medicamentosEnfermeira;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "cip")
    private String cip;
}
