package atc.atcsim;
import java.util.HashMap;

/**
 * Airspace class, implements the AirSpaces interface and defines all of its method, uses a hashmap to store planes in a given airspace. Provides methods to modify the contents
 * of the hashmap.
 *
 * @author Gautam Soni
 * @version 7/10/2024
 */
public class Airspace implements AirSpaces {
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
    @Override
    public void addToAirspace(Plane p) {
        if (airspaceOpen) {
            airspace.put(p.getPlaneCallSign(), p);
        }
    }

    /**
     * Removes the specified plane from the airspace
     * @param p Plane to be removed
     */
    @Override
    public void removeFromAirspace(Plane p) {
        if (getPlaneInAirspace(p) != null) {
            airspace.remove(p.getPlaneCallSign());
        }
    }

    /**
     * Getter method for the specified plane in airspace
     * @param p Plane to search for in airspace
     * @return Plane in the airspace
     */
    @Override
    public Plane getPlaneInAirspace(Plane p) {
        return airspace.get(p.getPlaneCallSign());
    }

    /**
     * Closes the airspace by marking the airspaceOpen variable as false.
     */
    @Override
    public void closeAirspace() {
        airspaceOpen = false;
    }

    /**
     * Opens the airspace by marking the airspaceOpen variable as true;
     */
    @Override
    public void openAirspace() {
        airspaceOpen = true;
    }

    /**
     * Getter method for the airspace clearance
     * @return true/false if the airspace is open
     */
    @Override
    public boolean getAirspaceClearance() {
        return airspaceOpen;
    }

    /**
     * Clears the airspace by removing all objects in the airspace hashmap.
     */
    @Override
    public void clearAirspace() {
        airspace.clear();
    }

    /**
     * Getter method for the airspace capacity
     * @return Number of planes currently in the airspace
     */
    @Override
    public int getAirspaceCapacity() {
        return airspace.size();
    }
}