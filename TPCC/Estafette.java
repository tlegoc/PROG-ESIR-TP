public class Estafette extends Vehicule {
    // Poids a vide 4.5 tonnes
    // Vitesse max de 120kmh
    // Charge max 0

    public Estafette(String immatriculation) {
        super(immatriculation);

        this.poidsVide = 4500;
        this.chargeMax = 0;
    }

    public double calculerVitesseMax() {
        return 120;
    }

    public double getPoidsTotal() {
        return getPoidsVide();
    }

    public void ajouterCharge(double ch) {
        // Do nothing
    }
}
