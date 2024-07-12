package atc.atcsim;
import java.util.HashMap;

/**
 * Airspace class, implements a hashmap to store planes in a given airspace. Provides methods to modify the contents
 * of the hashmap.
 *
 * @author Gautam Soni
 * @version 7/10/2024
 */
public class Airspace {
    // Fields
    private HashMap<String, Plane> airspace; // hashmap that stores all the planes
    private boolean airspaceOpen; // boolean to hold the status of whether the airspace is open or not

    /**
     * Create a new Airspace Object.
     */
    public Airspace() {
        airspace =  new HashMap<String, Plane>();
        airspaceOpen = true; // instantiate the airspace as open
    }

    /**
     * Adds the specified plane to the airspace if the airspace is open
     * @param p Plane to be added
     */
    public void addToAirspace(Plane p) {
        if (airspaceOpen) {
            airspace.put(p.getPlaneCallSign(), p);
        }
        else {
            System.out.println("The airspace is closed!");
        }
    }

    /**
     * Removes the specified plane from the airspace
     * @param p Plane to be removed
     */
    public void removeFromAirspace(Plane p) {
        if (p.getPlaneCallSign() != null) {
            airspace.remove(p.getPlaneCallSign());
        }
    }

    /**
     * Getter method for the specified plane in airspace
     * @param p Plane to search for in airspace
     * @return Plane in the airspace
     */
    public Plane getPlaneInAirspace(Plane p) {
        return airspace.get(p.getPlaneCallSign());
    }

    public void closeAirspace() {
        airspaceOpen = false;
    }

    public void clearAirspace() {
        airspace.clear();
    }
    public int getAirspaceCapacity() {
        return airspace.size();
    }
}
