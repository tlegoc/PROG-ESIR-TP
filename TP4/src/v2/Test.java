package v2;

/*
 * 
 * PAS DE CHANGEMENT
 * 
 * 
 */

public class Test {
    public static void main(String[] args) {
        Ferry ferry = new Ferry(100, 100);

        IVehicule v;
        do {
            double r = Math.random();
            if (r < 1.0 / 4.0)
                v = new Auto("AA-123-AA", 2, false);
            else if (r < 2.0 / 4.0)
                v = new Ambulance("CC-123-CC", 2, false);
            else if (r < 3.0 / 4.0)
                v = new Cycle("CY-123-CY");
            else
                v = new Bus("BB-123-BB", 10, (int) (Math.random() * 18 + 2));
        } while (ferry.ajouter(v));

        ferry.trier();
        System.out.println(ferry);
        System.out.println(ferry.calculerTarif() + "€");
    }
}
