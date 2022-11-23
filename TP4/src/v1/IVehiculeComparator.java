package v1;

import java.util.Comparator;

public class IVehiculeComparator {
    public static Comparator<IVehicule> compareTarifCroissant() {
        return (IVehicule v1, IVehicule v2) -> {
            return (int) (v1.calculerTarif() - v2.calculerTarif());
        };
    }

    public static Comparator<IVehicule> compareTarifDeroissant() {
        return (IVehicule v1, IVehicule v2) -> {
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
}
