package hospital.db.demo.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Internacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInternacao;

    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_leito")
    private Leito leito;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_enfermeira")
    private Enfermeira enfermeira;
}
