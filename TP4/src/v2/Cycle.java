package v2;

public class Cycle extends Vehicule {

    public String immatriculation;

    public Cycle(String immatriculation) {
        super(immatriculation, 1, 1);
        this.immatriculation = immatriculation;
    }

    @Override
    public float calculerTarif() {
        return 20 + 15;
    }

    @Override
    public Cycle clone() {
        return new Cycle(getImmatriculation());
    }

    @Override
    public String toString() {
        return "Cycle [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", tarif: " + calculerTarif()
                + "]";
    }
}
