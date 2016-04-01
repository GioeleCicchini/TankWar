package Shared.Domain;

import Shared.Domain.Caselle.ICasella;

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

    ICasella getCasellaPosizione();

    void setCasellaPosizione(ICasella casellaPosizione);

    void faiMossa(ITank altroTank, CampoBattaglia campo);

    boolean seiMorto();


}

