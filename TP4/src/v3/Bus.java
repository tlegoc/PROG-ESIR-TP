package v3;

public class Bus extends Vehicule {

    public Bus(String immatriculation, int passagers, int longueur) {
        super(immatriculation, passagers, longueur);
    }

    @Override
    public String toString() {
        return "Bus [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", longueur=" + getLongueur()
                +"]";
    }

    @Override
    public IVehicule clone() {
        return new Bus(getImmatriculation(), getPassagers(), getLongueur());
    }
}
