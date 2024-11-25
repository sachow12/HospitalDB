package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leito")
public class Leito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_leito")
    private Integer id;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "localizacao")
    private String localizacao;
    @Column(name = "is_ocupado")
    private Boolean isOcupado;
    @OneToMany(mappedBy = "leito", cascade = CascadeType.ALL)
    private List<Internacao> internacoes;
}
