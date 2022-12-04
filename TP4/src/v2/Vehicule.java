package v2;

/*
 * 
 * Toutes les fonctions ici sont des fonctions qui ne changent pas de vehicule en vehicule.
 * On peut donc se permettre de tout ecrire ici et de les ignorer dans les classes filles.
 * 
 * Il faudra juste change implements IVehicule (une interface) en extends Vehicule (une classe abstraite)
 * 
 * Certaines fonctions devront quand même etre redefinies dans les classes filles.
 * Exemple de toString().
 * 
 */


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
    public abstract float calculerTarif();

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
