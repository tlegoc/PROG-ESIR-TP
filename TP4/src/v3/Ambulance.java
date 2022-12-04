package v3;

//Pas de difference par rapport a la v2
public class Ambulance extends Auto {
    public Ambulance(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, toutTerrain);
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public IVehicule clone() {
        return new Ambulance(getImmatriculation(), getPassagers(), toutTerrain);
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String toString() {
        return "Ambulance [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", toutTerrain="
                + toutTerrain
                + "]";
    }
}
