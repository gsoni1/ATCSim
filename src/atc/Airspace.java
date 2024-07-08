package atc;
import java.util.HashMap;

public class Airspace {
    // fields
    private HashMap<String, Plane> airspace =  new HashMap<String, Plane>();

    public Airspace() {

    }

    public String addToAirspace(Plane p) {
        airspace.put(p.getPlaneCallSign(), p);
        return "Added " + p.getPlaneCallSign() + " to airspace";
    }

    public String removeFromAirspace(Plane p) {
        airspace.remove(p.getPlaneCallSign());
        return "Removed " + p.getPlaneCallSign() + " from airspace";
    }

    public Plane getPlaneInAirspace(Plane p) {
        return airspace.get(p.getPlaneCallSign());
    }
}
