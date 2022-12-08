package src;

public class Main {
    public static void main(String[] args) {

        //Creation des stations
        BikeStation bs1 = new BikeStation("BS1");
        BikeStation bs2 = new BikeStation("BS2");
        BikeStation bs3 = new BikeStation("BS3");


        //On creer 10 velos aleatoires qu'on depose dans une station au hasard
        int bike_count = 10;
        for (int i = 0; i < bike_count; i++) {
            double rdm1 = Math.random() * 2;
            Bike bike;
            if (rdm1 < 1)
                bike = new NewBike();
            else
                bike = new Bike();

            double rdm2 = Math.random() * 3;

            if (rdm2 < 1) {
                bs1.drop(bike);
            } else if (rdm2 < 2) {
                bs2.drop(bike);
            } else {
                bs3.drop(bike);
            }
        }

        System.out.println(bs1.toString());
        System.out.println(bs2.toString());
        System.out.println(bs3.toString());

        //On fais 6 echanges un peu aleatoires
        int echange_count = 6;
        for (int i = 0; i < echange_count; i++) {
            double rdm = Math.random() * 4;

            if (rdm < 1) {
                rentAndDrop(bs1, bs2);
            } else if (rdm < 2) {
                rentAndDrop(bs1, bs3);
            } else if (rdm < 3) {
                rentAndDrop(bs2, bs3);
            } else {
                rentAndDrop(bs3, bs1);
            }
        }

        System.out.println(bs1.toString());
        System.out.println(bs2.toString());
        System.out.println(bs3.toString());
    }

    public static <T extends Rentable<T>> void rentAndDrop(Renter<T> from, Renter<T> to) {
        T rentable = from.rent();
        if (rentable != null)
            to.drop(rentable);
    }
}
