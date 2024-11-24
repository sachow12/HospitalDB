package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exames")
public class Exames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date realizacao;

    private String status;

    @ElementCollection
    private List<String> resultados;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
}