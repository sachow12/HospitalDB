package hospital.db.demo.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum ExamesStatus {
    CANCELADO(1),
    ADIADO(2),
    PROXIMO(3),
    EM_ANDAMENTO(4),
    CONCLUIDO(5);
    private int code;


    public static ExamesStatus valueOf(int code) {
    for(ExamesStatus e : ExamesStatus.values()) {
        if(e.code == code) {
            return e;
        }
    }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }
}
