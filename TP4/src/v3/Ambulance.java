package v3;

public class Ambulance extends Auto {
    public Ambulance(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, toutTerrain);
    } 

    @Override
    public IVehicule clone() {
        return new Ambulance(getImmatriculation(), getPassagers(), toutTerrain);
    }

    @Override
    public String toString() {
        return "Ambulance [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", toutTerrain=" + toutTerrain
                +"]";
    }
}
