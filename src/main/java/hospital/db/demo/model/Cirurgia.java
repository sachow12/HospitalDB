package hospital.db.demo.model;

import hospital.db.demo.model.Enum.CirugiaGrauDeRisco;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cirurgia")
public class Cirurgia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cirurgia")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "id_atendimento")
    private Atendimento atendimento;
    @Column(name = "tipo_cirurgia")
    private String tipoCirurgia;
    @Column(name = "grau_de_risco")
    private CirugiaGrauDeRisco grauDeRisco;
}
