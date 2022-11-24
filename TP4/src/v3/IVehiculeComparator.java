package v3;

import java.util.Comparator;
import java.util.HashMap;

public class IVehiculeComparator {
    public static Comparator<IVehicule> compareTarifCroissant(HashMap<String, Tarif> tarifs) {
        return (IVehicule v1, IVehicule v2) -> {
            Tarif tarifV1 = tarifs.get(v1.getImmatriculation());
            Tarif tarifV2 = tarifs.get(v2.getImmatriculation());
            return (int) (tarifV1.calculerTarif(v1) - tarifV2.calculerTarif(v2));
        };
    }

    public static Comparator<IVehicule> compareTarifDeroissant(HashMap<String, Tarif> tarifs) {
        return (IVehicule v1, IVehicule v2) -> {
            Tarif tarifV1 = tarifs.get(v1.getImmatriculation());
            Tarif tarifV2 = tarifs.get(v2.getImmatriculation());
            return -1 * ((int) (tarifV1.calculerTarif(v1) - tarifV2.calculerTarif(v2)));
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
