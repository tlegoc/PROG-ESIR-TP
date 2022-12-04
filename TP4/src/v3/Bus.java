package v3;

//Pas de difference par rapport a la v2
public class Bus extends Vehicule {

    public Bus(String immatriculation, int passagers, int longueur) {
        super(immatriculation, passagers, longueur);
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public String toString() {
        return "Bus [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", longueur="
                + getLongueur()
                + "]";
    }

    // On oublie pas le @override pour bien indiquer qu'on remplace la methode
    // d'origine
    @Override
    public IVehicule clone() {
        return new Bus(getImmatriculation(), getPassagers(), getLongueur());
    }
}
