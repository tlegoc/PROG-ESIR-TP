package v3;


//On redefini les calculs de tarif
public class TarifAmbulance extends Tarif {
    protected static Tarif instance = null;

    protected TarifAmbulance() {
        super(0, 0, 0);  
    }

    public static Tarif createInstance() {
        if (instance == null) {
            instance = new TarifAmbulance();
        }
        return instance;
    }

    public static Tarif getInsance() {
        return instance;
    }

    public float calculerTarif(IVehicule v) {
        return 0;
    }
}