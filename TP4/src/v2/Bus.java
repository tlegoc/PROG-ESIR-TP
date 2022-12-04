package v2;

//Comme beaucoup de code a ete modifie, on peut en enlever beaucoup de chaque vehicule
//Le code qui etait le meme pour tout les vehicules a ete mis dans Vehicule.java
public class Bus extends Vehicule {

    public Bus(String immatriculation, int passagers, int longueur) {
        super(immatriculation, passagers, longueur);
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
@Override
    public float calculerTarif() {
        return 200 + 50 * getLongueur() + 15 * getPassagers();
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
@Override
    public String toString() {
        return "Bus [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", longueur=" + getLongueur()
                + ", tarif: " + calculerTarif() + "]";
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
@Override
    public IVehicule clone() {
        return new Bus(getImmatriculation(), getPassagers(), getLongueur());
    }
}
