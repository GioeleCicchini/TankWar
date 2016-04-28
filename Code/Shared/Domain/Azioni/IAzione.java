package Shared.Domain.Azioni;


import Shared.Domain.CampoBattaglia;
import Shared.Domain.ITank;

public interface IAzione {

    boolean eseguiti(ITank tankTurno, ITank tankAvversario, CampoBattaglia campo);

}