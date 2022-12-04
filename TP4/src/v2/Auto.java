package v2;

//Comme beaucoup de code a ete modifie, on peut en enlever beaucoup de chaque vehicule
//Le code qui etait le meme pour tout les vehicules a ete mis dans Vehicule.java
public class Auto extends Vehicule {

    protected boolean toutTerrain;

    public Auto(String immatriculation, int passagers, boolean toutTerrain) {
        super(immatriculation, passagers, 2);
        this.toutTerrain = toutTerrain;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public float calculerTarif() {
        return toutTerrain ? 350 : 100 + 15 * getPassagers();
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String toString() {
        return "Auto [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", toutTerrain="
                + toutTerrain
                + ", tarif: " + calculerTarif() + "]";
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public IVehicule clone() {
        return new Auto(getImmatriculation(), getPassagers(), toutTerrain);
    }
}
