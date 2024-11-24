package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Temporal(TemporalType.DATE)
    private Date validade;

    private Long lote;

    private String fabricante;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
}
