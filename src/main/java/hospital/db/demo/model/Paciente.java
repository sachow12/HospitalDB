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
    private Integer id;

    private String nome;

    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @ElementCollection
    private List<String> endereco;

    @ElementCollection
    private List<String> telefone;

    @ElementCollection
    private List<String> telefoneDeEmergencia;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Exames> exames;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Visitante> visitantes;
}
