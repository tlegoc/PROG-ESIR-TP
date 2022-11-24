package v3;

public class Auto extends Vehicule {

    protected boolean toutTerrain;

    public Auto(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, 2);
        this.toutTerrain = toutTerrain;
    }

    @Override
    public String toString() {
        return "Auto [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", toutTerrain=" + toutTerrain
                + "]";
    }

    @Override
    public IVehicule clone() {
        return new Auto(getImmatriculation(), getPassagers(), toutTerrain);
    }

    public boolean isToutTerrain() {
        return toutTerrain;
    }
}
