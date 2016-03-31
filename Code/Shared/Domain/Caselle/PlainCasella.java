package Shared.Domain.Caselle;

/**
 * Created by beniamino on 31/03/16.
 */
public class PlainCasella implements ICasella {

    public boolean disponibile = true;


    @Override
    public boolean isDisponibile() {
        return disponibile;
    }
}
