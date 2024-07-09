package atc;
import java.util.HashMap;

/**
 * Airspace class, implements a hashmap to store planes in a given airspace. Provides methods to modify the contents
 * of the hashmap.
 */
public class Airspace {
    // Fields
    private HashMap<String, Plane> airspace =  new HashMap<String, Plane>();

    /**
     * Create a new Airspace Object.
     */
    public Airspace() {
        //
    }

    /**
     * Adds the specified plane to the airspace
     * @param p Plane to be added
     */
    public void addToAirspace(Plane p) {
        airspace.put(p.getPlaneCallSign(), p);
//        return "Added " + p.getPlaneCallSign() + " to airspace";
    }

    /**
     * Removes the specified plane from the airspace
     * @param p Plane to be removed
     */
    public void removeFromAirspace(Plane p) {
        airspace.remove(p.getPlaneCallSign());
//        return "Removed " + p.getPlaneCallSign() + " from airspace";
    }

    /**
     * Getter method for the specified plane in airspace
     * @param p Plane to search for in airspace
     * @return Plane in the airspace
     */
    public Plane getPlaneInAirspace(Plane p) {
        return airspace.get(p.getPlaneCallSign());
    }
}
