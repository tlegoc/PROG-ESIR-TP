package v2;

//Comme beaucoup de code a ete modifie, on peut en enlever beaucoup de chaque vehicule
//Le code qui etait le meme pour tout les vehicules a ete mis dans Vehicule.java
public class Cycle extends Vehicule {

    public String immatriculation;

    public Cycle(String immatriculation) {
        super(immatriculation, 1, 1);
        this.immatriculation = immatriculation;
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
@Override
    public float calculerTarif() {
        return 20 + 15;
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
@Override
    public Cycle clone() {
        return new Cycle(getImmatriculation());
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
@Override
    public String toString() {
        return "Cycle [immatriculation=" + getImmatriculation() + ", passagers=" + getPassagers() + ", tarif: " + calculerTarif()
                + "]";
    }
}
