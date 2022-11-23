package v1;

public class Ambulance extends Auto {
    public Ambulance(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, toutTerrain);
    } 

    @Override 
    public float calculerTarif() {
        return 0;
    }

    @Override
    public String toString() {
        return "Ambulance [immatriculation=" + immatriculation + ", passagers=" + passagers + ", toutTerrain=" + toutTerrain
                + ", tarif: " + calculerTarif() + "]";
    }

    @Override
    public IVehicule clone() {
        return new Ambulance(immatriculation, passagers, toutTerrain);
    }
}
