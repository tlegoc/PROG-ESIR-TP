package src;
public class Bike implements Rentable<Bike> {

    private String ID;
    
    public Bike() {
        //Pas oblige mais dans le doute
        this.ID = "" + this.hashCode();
    }

    public String getId() {
        return this.ID;
    }
}
