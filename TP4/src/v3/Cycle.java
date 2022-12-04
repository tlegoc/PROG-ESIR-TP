package v3;

//Pas de difference par rapport a la v2
public class Cycle extends Vehicule {

    public String immatriculation;

    public Cycle(String immatriculation) {
        super(immatriculation, 1, 1);
        this.immatriculation = immatriculation;
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public Cycle clone() {
        return new Cycle(getImmatriculation());
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String toString() {
        return "Cycle [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + "]";
    }
}
