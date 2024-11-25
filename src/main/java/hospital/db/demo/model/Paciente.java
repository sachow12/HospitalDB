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
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento")
    private Date dataNascimento;
    @ElementCollection
    @CollectionTable(name = "endereco_paciente", joinColumns = @JoinColumn(name = "id_paciente"))
    @Column(name = "endereco")
    private List<String> endereco;
    @ElementCollection
    @CollectionTable(name = "telefone_paciente", joinColumns = @JoinColumn(name = "id_paciente"))
    @Column(name = "telefone")
    private List<String> telefone;
    @ElementCollection
    @CollectionTable(name = "contato_emergencia_paciente", joinColumns = @JoinColumn(name = "id_paciente"))
    @Column(name = "contato_emergencia")
    private List<String> contatoEmergencia;
}
