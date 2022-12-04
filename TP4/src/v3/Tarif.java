package v3;

import java.util.HashMap;

/**
 * Classe tarif qui contient les methodes pour calculer le tarif
 * 
 * Cette classe ne sera pas utilisee en tant que tel, mais elle sera heritee par les classes filles
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