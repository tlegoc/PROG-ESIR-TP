package v3;

//Pas de difference par rapport a la v2
public class Auto extends Vehicule {

    protected boolean toutTerrain;

    public Auto(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, 2);
        this.toutTerrain = toutTerrain;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String toString() {
        return "Auto [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", toutTerrain="
                + toutTerrain
                + "]";
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public IVehicule clone() {
        return new Auto(getImmatriculation(), getPassagers(), toutTerrain);
    }

    public boolean isToutTerrain() {
        return toutTerrain;
    }
}
