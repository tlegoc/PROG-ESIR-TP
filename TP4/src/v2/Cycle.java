package v2;

public class Cycle implements IVehicule {

    public String immatriculation;

    public Cycle(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    @Override
    public int getPassagers() {
        return 1;
    }

    @Override
    public int getLongueur() {
        return 1;
    }

    @Override
    public String getImmatriculation() {
        return "CY-123-CY";
    }

    @Override
    public float calculerTarif() {
        return 20 + 15;
    }

    @Override
    public String toString() {
        return "Cycle [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", longueur=" + getLongueur()
                + ", tarif: " + calculerTarif() + "]";
    }

    @Override
    public Cycle clone() {
        return new Cycle(immatriculation);
    }

    @Override
    public int compareTo(IVehicule o) {
        return this.getLongueur() - o.getLongueur();
    }
}
