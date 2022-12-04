package v1;

public class Cycle implements IVehicule {

    //Variables qui peuvent varier d'un vehicule a l'autre  
    //On n'y met pas tout ce qui est prix/etc car c'est toujours le meme
    public String immatriculation;

    public Cycle(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public int getPassagers() {
        return 1;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public int getLongueur() {
        return 1;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String getImmatriculation() {
        return "CY-123-CY";
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public float calculerTarif() {
        return 20 + 15;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String toString() {
        return "Cycle [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", longueur="
                + getLongueur()
                + ", tarif: " + calculerTarif() + "]";
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public Cycle clone() {
        return new Cycle(immatriculation);
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public int compareTo(IVehicule o) {
        return this.getLongueur() - o.getLongueur();
    }
}
