package v3;

public class TarifBus extends Tarif {
    protected static Tarif instance = null;

    protected TarifBus(float tarifFixe, float tarifVariable, float tarifPassager) {
        super(tarifFixe, tarifVariable, tarifPassager);  
    }

    public static Tarif createInstance(float tarifFixe, float tarifVariable, float tarifPassager) {
        if (instance == null) {
            instance = new TarifBus(tarifFixe, tarifVariable, tarifPassager);
        }
        return instance;
    }

    public static Tarif getInsance() {
        return instance;
    }

    public float calculerTarif(IVehicule v) {
        if (v instanceof Bus) {
            Bus a = (Bus) v;
            return a.getLongueur() * tarifVariable + tarifFixe + a.getPassagers() * tarifPassager;
        } else {
            return tarifFixe + v.getPassagers() * tarifPassager;
        }
    }
}