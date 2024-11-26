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
    @Column(name = "id_medicamento")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "validade")
    private Date validade;
    @Column(name = "lote")
    private Long lote;
    @Column(name = "fabricante")
    private String fabricante;
    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;
    @ManyToOne
    @JoinColumn(name = "id_enfermeira")
    private Enfermeira enfermeira;
}
