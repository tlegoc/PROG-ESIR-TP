package v2;

public class Auto extends Vehicule {

    protected boolean toutTerrain;

    public Auto(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, 2);
        this.toutTerrain = toutTerrain;
    }

    @Override
    public float calculerTarif() {
        return toutTerrain ? 350 : 100 + 15 * getPassagers();
    }

    @Override
    public String toString() {
        return "Auto [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", toutTerrain=" + toutTerrain
                + ", tarif: " + calculerTarif() + "]";
    }

    @Override
    public IVehicule clone() {
        return new Auto(getImmatriculation(), getPassagers(), toutTerrain);
    }
}
