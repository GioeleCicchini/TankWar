package Shared.Util;

/**
 * Created by emanuele on 22/03/16.
 */
public enum OrientamentoEnum {
    N(0),
    O(1),
    E(2),
    S(3);

    private Integer numero;

    OrientamentoEnum(Integer numero) {
    }

    public Integer getNumero() {
        return this.numero;
    }

    public static OrientamentoEnum getEnumByNumero(Integer numero) {
        OrientamentoEnum orientamento = null;
        switch (numero) {
            case 0: orientamento = OrientamentoEnum.N;
                break;
            case 1: orientamento = OrientamentoEnum.E;
                break;
            case 2: orientamento = OrientamentoEnum.S;
                break;
            case 3: orientamento = OrientamentoEnum.O;
                break;
        }
        return orientamento;
    }
}
