package Shared.Domain;

/**
 * Created by beniamino on 22/03/16.
 */
public interface ITank {

    void setStrategia(Strategia strategia);
    Strategia getStrategia();

    ITank getTank();
    void setTank(Tank tank);

    Integer getLivello();

    String getId();
    void setId(String id);
}

