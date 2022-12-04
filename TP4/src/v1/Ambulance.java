package v1;

public class Ambulance extends Auto {

    //On redefinis le constructeur
    public Ambulance(String immatriculation, int passagers, boolean toutTerrain) {
        //super() appelle le constructeur de la classe parente, ici Auto
        super(immatriculation, passagers, toutTerrain);
    } 


    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override 
    public float calculerTarif() {
        return 0;
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public String toString() {
        return "Ambulance [immatriculation=" + immatriculation + ", passagers=" + passagers + ", toutTerrain=" + toutTerrain
                + ", tarif: " + calculerTarif() + "]";
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public IVehicule clone() {
        return new Ambulance(immatriculation, passagers, toutTerrain);
    }
}
