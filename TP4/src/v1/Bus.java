package v1;

public class Bus implements IVehicule {

    //Variables qui peuvent varier d'un vehicule a l'autre  
    //On n'y met pas tout ce qui est prix/etc car c'est toujours le meme
    public int longueur;
    public int passagers;
    public String immatriculation;

    //Constructeur
    public Bus(String immatriculation, int passagers, int longueur) {
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
    public float calculerTarif() {
        return 200 + 50 * longueur + 15 * passagers;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String toString() {
        return "Bus [immatriculation=" + immatriculation + ", passagers=" + passagers + ", longueur=" + longueur
                + ", tarif: " + calculerTarif() + "]";
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public IVehicule clone() {
        // Voir la classe Auto pour plus d'explications
        return new Bus(immatriculation, passagers, longueur);
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public int compareTo(IVehicule o) {
        // Voir la classe Auto pour plus d'explications
        return this.getLongueur() - o.getLongueur();
    }
}
