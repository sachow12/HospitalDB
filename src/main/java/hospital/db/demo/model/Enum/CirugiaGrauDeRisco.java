package hospital.db.demo.model.Enum;

public enum CirugiaGrauDeRisco {
    NENHUM("NENHUM"),
    BAIXO("BAIXO"),
    MEDIO("MEDIO"),
    GRAVE("GRAVE");
    private String descricao;
    private CirugiaGrauDeRisco(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
