package v3;

public abstract class Vehicule implements IVehicule {

    private int longueur;
    protected int passagers;
    protected String immatriculation;

    public Vehicule(String immatriculation, int passagers, int longueur) {
        this.immatriculation = immatriculation;
        this.passagers = passagers;
        this.longueur = longueur;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public int getPassagers() {
        return passagers;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public int getLongueur() {
        return longueur;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String getImmatriculation() {
        return immatriculation;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public abstract String toString();

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public abstract IVehicule clone();

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public int compareTo(IVehicule o) {
        return this.getLongueur() - o.getLongueur();
    }

}
