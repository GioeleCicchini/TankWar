package Shared.Domain.Creator.AzioneCreator;

import Shared.Domain.Azioni.IAzione;

import java.util.ArrayList;

/**
 * Created by beniamino on 26/02/16.
 */
public interface IAzioneCreator {
    IAzione doMakeAzione (String idAz, ArrayList<Integer>valori);
}
