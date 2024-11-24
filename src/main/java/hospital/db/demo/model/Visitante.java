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
    private Integer id;

    private String nome;

    private String parentesco;

    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoVisita;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
}
