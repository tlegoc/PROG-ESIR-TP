package v1;

public class Auto implements IVehicule {

    //Variables qui peuvent varier d'un vehicule a l'autre  
    //On n'y met pas tout ce qui est prix/etc car c'est toujours le meme
    protected String immatriculation;
    protected int passagers;
    protected boolean toutTerrain;

    //On definit le constructeur
    public Auto(String immatriculation, int passagers, boolean toutTerrain) {
        this.immatriculation = immatriculation;
        this.passagers = passagers;
        this.toutTerrain = toutTerrain;
    }

    //Optionnel : on creer un constructeur qui ne prend qu'une plaque d'immatriculation. On mettra les autres valeurs par defaut
    public Auto(String immatriculation) {
        this.immatriculation = immatriculation;
        this.passagers = 0;
        this.toutTerrain = false;
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public int getPassagers() {
        return passagers;
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public int getLongueur() {
        return 2;
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public String getImmatriculation() {
        return immatriculation;
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public float calculerTarif() {

        //On calcule le tarif en fonction du nombre de passagers
        return toutTerrain ? 350 : 100 + 15 * passagers;

        /*
         * On aurait pu ecrire:
         * if(toutTerrain) {
         *    return 350;
         * } else {
         *   return 100 + 15 * passagers;
         * }
         */
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public String toString() {
        return "Auto [immatriculation=" + immatriculation + ", passagers=" + passagers + ", toutTerrain=" + toutTerrain
                + ", tarif: " + calculerTarif() + "]";
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public IVehicule clone() {
        //Clone demande de renvoyer une nouvelle instance de la classe, ici Auto
        //On cree donc un nouvel objet avec le mot cle new
        return new Auto(immatriculation, passagers, toutTerrain);
    }

    //On oublie pas le @override pour bien indiquer qu'on remplace la methode d'origine
    @Override
    public int compareTo(IVehicule o) {
        //Valeur negative si this est plus petit que o
        //Sinon, valeur positive
        return this.getLongueur() - o.getLongueur();
    }
}
