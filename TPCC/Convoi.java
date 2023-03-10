import java.util.ArrayList;
import java.util.List;

public class Convoi {
    List<Vehicule> vehicules;

    public Convoi() {
        vehicules = new ArrayList<Vehicule>();
    }

    public void ajouter(Vehicule v) {
        vehicules.add(v);
    }

    public double calculerVitesseMax() {
        double vitesseMax = 0;
        for (Vehicule v : vehicules) {
            if (v.calculerVitesseMax() > vitesseMax) {
                vitesseMax = v.calculerVitesseMax();
            }
        }
        return vitesseMax;
    }

    public double consommationTotale() {
        double consommationTotale = 0;
        double vitesseMax = calculerVitesseMax();
        for (Vehicule v : vehicules) {
            consommationTotale += v.getConsommation(vitesseMax);
        }
        return consommationTotale;
    }
}
