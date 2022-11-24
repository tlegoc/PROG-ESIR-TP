package v2;

public class Ambulance extends Auto {
    public Ambulance(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, toutTerrain);
    } 

    @Override 
    public float calculerTarif() {
        return 0;
    }

    @Override
    public IVehicule clone() {
        return new Ambulance(getImmatriculation(), getPassagers(), toutTerrain);
    }

    @Override
    public String toString() {
        return "Ambulance [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", toutTerrain=" + toutTerrain
                + ", tarif: " + calculerTarif() + "]";
    }
}
