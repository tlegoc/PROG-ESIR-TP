package v2;

public class Auto implements IVehicule {

    protected String immatriculation;
    protected int passagers;
    protected boolean toutTerrain;

    public Auto(String immatriculation, int passagers, boolean toutTerrain) {
        this.immatriculation = immatriculation;
        this.passagers = passagers;
        this.toutTerrain = toutTerrain;
    }

    public Auto(String immatriculation) {
        this.immatriculation = immatriculation;
        this.passagers = 0;
        this.toutTerrain = false;
    }

    @Override
    public int getPassagers() {
        return passagers;
    }

    @Override
    public int getLongueur() {
        return 2;
    }

    @Override
    public String getImmatriculation() {
        return immatriculation;
    }

    @Override
    public float calculerTarif() {

        return toutTerrain ? 350 : 100 + 15 * passagers;
    }

    @Override
    public String toString() {
        return "Auto [immatriculation=" + immatriculation + ", passagers=" + passagers + ", toutTerrain=" + toutTerrain
                + ", tarif: " + calculerTarif() + "]";
    }

    @Override
    public IVehicule clone() {
        return new Auto(immatriculation, passagers, toutTerrain);
    }

    @Override
    public int compareTo(IVehicule o) {
        return this.getLongueur() - o.getLongueur();
    }
}
