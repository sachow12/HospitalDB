package hospital.db.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Leito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numero;

    private String localizacao;

    private Boolean isOcupado;

    @OneToMany(mappedBy = "leito", cascade = CascadeType.ALL)
    private List<Internacao> internacoes;
}
