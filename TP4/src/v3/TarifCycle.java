package v3;

public class TarifCycle extends Tarif {
    protected static Tarif instance = null;

    protected TarifCycle(float tarifFixe, float tarifPassager) {
        super(tarifFixe, 0, tarifPassager);
    }

    public static Tarif createInstance(float tarifFixe, float tarifPassager) {
        if (instance == null) {
            instance = new TarifCycle(tarifFixe, tarifPassager);
        }
        return instance;
    }

    public static Tarif getInsance() {
        return instance;
    }

    public float calculerTarif(IVehicule v) {
        return tarifFixe + v.getPassagers() * tarifPassager;
    }
}