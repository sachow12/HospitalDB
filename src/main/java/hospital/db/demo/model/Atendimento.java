package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "atendimento")
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atendimento")
    private Date dataAtendimento;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "recomendacao")
    private String recomendacao;
    @Column(name = "tipo_atendimento")
    private String tipoAtendimento;
}
