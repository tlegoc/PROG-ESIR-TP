package src;
import java.util.UUID;

public class NewBike extends Bike {

    private String BikeUUID;

    public NewBike() {
        //Pour eviter de regenerer un UUID a chaque fois et donc de perdre le velo
        this.BikeUUID = UUID.randomUUID().toString();;
    }

    @Override
    public String getId() {
        return BikeUUID;
    }
}
