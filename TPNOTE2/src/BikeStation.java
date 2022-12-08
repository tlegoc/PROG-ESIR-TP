package src;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BikeStation implements Renter<Bike> {
    private Map<String, Bike> table = new HashMap<String, Bike>();
    private String name;

    public BikeStation(String name) {
        this.name = name;
    }


    @Override
    public void drop(Bike rentable) {
        table.put(rentable.getId(), rentable);    
    }

    @Override
    public Bike rent() {
        //On evite les crashs du a une station vide
        if (table.size() == 0) return null;

        //Recuperation du premier velo disponible
        Bike bike = table.entrySet().iterator().next().getValue();

        table.remove(bike.getId());

        return bike;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Bike station: ");
        sb.append(this.name);
        sb.append(" [");

        Set<String> keys = table.keySet();

        for (String id : keys) {
            sb.append(id);
            sb.append(", ");
        }

        sb.replace(sb.length()-2, sb.length(), "");
        sb.append("]");

        return sb.toString();
    }
}
