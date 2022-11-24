package v2;

public class Bus extends Vehicule {

    public Bus(String immatriculation, int passagers, int longueur) {
        super(immatriculation, passagers, longueur);
    }

    @Override
    public float calculerTarif() {
        return 200 + 50 * getLongueur() + 15 * getPassagers();
    }

    @Override
    public String toString() {
        return "Bus [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", longueur=" + getLongueur()
                + ", tarif: " + calculerTarif() + "]";
    }

    @Override
    public IVehicule clone() {
        return new Bus(getImmatriculation(), getPassagers(), getLongueur());
    }
}
