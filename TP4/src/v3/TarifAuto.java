package v3;

//On redefini les calculs de tarif
public class TarifAuto extends Tarif {
    protected static Tarif instance = null;

    protected TarifAuto(float tarifFixe, float tarifVariable, float tarifPassager) {
        super(tarifFixe, tarifVariable, tarifPassager);  
    }

    public static Tarif createInstance(float tarifFixe, float tarifVariable, float tarifPassager) {
        if (instance == null) {
            instance = new TarifAuto(tarifFixe, tarifVariable, tarifPassager);
        }
        return instance;
    }

    public static Tarif getInsance() {
        return instance;
    }

    public float calculerTarif(IVehicule v) {
        if (v instanceof Auto) {
            Auto a = (Auto) v;
            return (a.isToutTerrain() ? tarifVariable : tarifFixe) + a.getPassagers() * tarifPassager;
        } else {
            return tarifFixe + v.getPassagers() * tarifPassager;
        }
    }
}