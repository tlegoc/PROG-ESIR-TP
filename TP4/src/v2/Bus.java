package v2;

public class Bus implements IVehicule {

    public int longueur;
    public int passagers;
    public String immatriculation;

    public Bus(String immatriculation, int passagers, int longueur) {
        this.immatriculation = immatriculation;
        this.passagers = passagers;
        this.longueur = longueur;
    }

    @Override
    public int getPassagers() {
        return passagers;
    }

    @Override
    public int getLongueur() {
        return longueur;
    }

    @Override
    public String getImmatriculation() {
        return immatriculation;
    }

    @Override
    public float calculerTarif() {
        return 200 + 50 * longueur + 15 * passagers;
    }

    @Override
    public String toString() {
        return "Bus [immatriculation=" + immatriculation + ", passagers=" + passagers + ", longueur=" + longueur
                + ", tarif: " + calculerTarif() + "]";
    }

    @Override
    public IVehicule clone() {
        return new Bus(immatriculation, passagers, longueur);
    }

    @Override
    public int compareTo(IVehicule o) {
        return this.getLongueur() - o.getLongueur();
    }
}
