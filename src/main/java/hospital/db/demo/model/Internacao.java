package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "internacao")
public class Internacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_internacao")
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_internacao")
    private Date dataInternacao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alta")
    private Date dataAlta;
    @Column(name = "motivo")
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "leito_id")
    private Leito leito;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_enfermeira")
    private Enfermeira enfermeira;
}
