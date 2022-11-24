package v3;

public class Test {
    public static void main(String[] args) {
        Ferry ferry = new Ferry(100, 100);

        float tarifPassager = 15 * 1.1f;

        TarifAmbulance.createInstance();
        TarifAuto.createInstance(100, 700, tarifPassager);
        TarifCycle.createInstance(20, tarifPassager);
        TarifBus.createInstance(200, 50, tarifPassager);

        IVehicule v;
        Tarif t;
        do {

            String imm = getAlphaNumericString(10);
            double r = Math.random();
            if (r < 1.0 / 4.0) {
                v = new Auto(imm, 2, false);
                t = TarifAuto.getInsance();
            }
            else if (r < 2.0 / 4.0) {
                v = new Ambulance(imm, 2, false);
                t = TarifAmbulance.getInsance();
            }
            else if (r < 3.0 / 4.0) {
                v = new Cycle(imm);
                t = TarifCycle.getInsance();
            }
            else {
                v = new Bus(imm, 10, (int) (Math.random() * 18 + 2));
                t = TarifBus.getInsance();
            }
        } while (ferry.ajouter(v, t));

        ferry.trier();
        System.out.println(ferry);
        System.out.println(ferry.calculerTarif() + "€");
    }


    //https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
