import java.util.ArrayList;
import java.util.List;

public class Convoi {
    List<Vehicule> vehicules;

    public Convoi() {
        this.vehicules = new ArrayList<Vehicule>();
    }

    public void ajouter(Vehicule v) {
        this.vehicules.add(v);
    }

    public double calculerVitesseMax() {
        double vitesseMax = 999999999;
        for (Vehicule v : vehicules) {
            if (v.calculerVitesseMax() < vitesseMax) {
                vitesseMax = v.calculerVitesseMax();
            }
        }
        return vitesseMax;
    }

    public double consommationTotale() {
        double consommationTotale = 0;
        double vitesseMax = this.calculerVitesseMax();
        for (Vehicule vehicule : vehicules) {
            consommationTotale += vehicule.getConsommation(vitesseMax);
        }
        return consommationTotale;
    }
}
