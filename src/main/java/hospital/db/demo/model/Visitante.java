package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visitante")
public class Visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visitante")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;
    @Column(name = "nome")
    private String nome;
    @Column(name = "parentesco")
    private String parentesco;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "periodo_visita")
    private Date periodoVisita;
    @Column(name = "telefone")
    private String telefone;
}
