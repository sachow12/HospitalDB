package hospital.db.demo.model;

import hospital.db.demo.model.Enum.ExamesStatus;
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
    @Column(name = "id_exames")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "realizacao")
    private Date realizacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_exame")
    private ExamesStatus statusExame;
    @ElementCollection
    @CollectionTable(name = "resultados", joinColumns = @JoinColumn(name = "id_exame"))
    @Column(name = "resultado")
    private List<String> resultados;
}