package v3;

import java.util.HashMap;

/**
 * Tarif
 */
public abstract class Tarif {

    public float tarifFixe;
    public float tarifVariable;
    public float tarifPassager;

    public abstract float calculerTarif(IVehicule v);

    protected Tarif(float tarifFixe, float tarifVariable, float tarifPassager) {
        this.tarifFixe = tarifFixe;
        this.tarifVariable = tarifVariable;
        this.tarifPassager = tarifPassager;
    }
}