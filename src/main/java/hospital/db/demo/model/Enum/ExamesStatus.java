package hospital.db.demo.model.Enum;


public enum ExamesStatus {
    CANCELADO("CANCELADO"),
    ADIADO("ADIADO"),
    PROXIMO("PROXIMO"),
    ANDAMENTO("ANDAMENTO"),
    CONCLUIDO("CONCLUIDO");
    private String descricao;
    ExamesStatus(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
    return descricao;
    }

}
