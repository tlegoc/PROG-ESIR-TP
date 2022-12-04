package v3;

import java.util.Comparator;
import java.util.HashMap;

public class IVehiculeComparator {

    /*
     * 
     * L'avantage des fonction lambda est qu'on peut les passer en parametre une valeur qui va changer le fonctionnement de la fonction.
     * 
     * Par exemple pour tarif, quand on demande une fonction qui compare les tarifs, on lui envoie
     * la table qui associe une immatriculation a un calculateur de tarif.
     * 
     */

    public static Comparator<IVehicule> compareTarifCroissant(HashMap<String, Tarif> tarifs) {
        return (IVehicule v1, IVehicule v2) -> {

            //On recupere les tarifs
            Tarif tarifV1 = tarifs.get(v1.getImmatriculation());
            Tarif tarifV2 = tarifs.get(v2.getImmatriculation());


            //On renvoie la difference
            return (int) (tarifV1.calculerTarif(v1) - tarifV2.calculerTarif(v2));
        };
    }

    //Cf compareTarifCroissant
    public static Comparator<IVehicule> compareTarifDeroissant(HashMap<String, Tarif> tarifs) {
        return (IVehicule v1, IVehicule v2) -> {
            Tarif tarifV1 = tarifs.get(v1.getImmatriculation());
            Tarif tarifV2 = tarifs.get(v2.getImmatriculation());
            return -1 * ((int) (tarifV1.calculerTarif(v1) - tarifV2.calculerTarif(v2)));
        };
    }

    //Ce comparateur prend deux autres comparateurs en parametre
    //Et renvoie un nouveau comparateur qui utilise les deux.
    //Si le comparateur c1 renvoie 0 (cad les 2 vehicules sont egaux), on utilise le comparateur c2
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
