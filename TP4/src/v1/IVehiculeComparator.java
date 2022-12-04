package v1;

import java.util.Comparator;

public class IVehiculeComparator {

    /*
     * Une fonction lambda est une fonction que l'on peut reutiliser sans forcement ecrire
     * public static machin(blab ablba blala)
     * 
     * Pour ca on ecris (TYPE NomDuParametre) -> {mon code};
     * 
     * Ce qui est bien c'est qu'on peut ensuite stocker cette fonction dans une variable
     * et l'envoyer en parametre.
     * 
     * Ici on renvoie des methodes qui renvoient un entier positif ou negatif, selon
     * la facon dont on veut trier les vehicules
     * 
     */








    public static Comparator<IVehicule> compareTarifCroissant() {
        return (IVehicule v1, IVehicule v2) -> {
            return (int) (v1.calculerTarif() - v2.calculerTarif());
        };
    }

    public static Comparator<IVehicule> compareTarifDeroissant() {
        return (IVehicule v1, IVehicule v2) -> {
            //Quand on inverse l'ordre on peut juste multiplier par -1 (cf explication en haut)
            return -1 * (int) (v1.calculerTarif() - v2.calculerTarif());
        };
    }

    public static Comparator<IVehicule> compareMulti(Comparator<IVehicule> c1, Comparator<IVehicule> c2) {
        return (IVehicule v1, IVehicule v2) -> {
            int res = c1.compare(v1, v2);
            if (res == 0)
                return c2.compare(v1, v2);
            return res;
        };
    }

    public static Comparator<IVehicule> compareLongueurCroissant() {
        return (IVehicule v1, IVehicule v2) -> {
            return v1.getLongueur() - v2.getLongueur();
        };
    }
    
    public static Comparator<IVehicule> compareLongueurDeroissant() {
        return (IVehicule v1, IVehicule v2) -> {
            return -1 * (v1.getLongueur() - v2.getLongueur());
        };
    }
}
