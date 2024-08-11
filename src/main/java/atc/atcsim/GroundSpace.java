package atc.atcsim;
import java.util.HashMap;

/**
 * groundspace class, implements the groundSpaces interface and defines all of its method, uses a hashmap to store planes in a given groundspace. Provides methods to modify the contents
 * of the hashmap.
 *
 * @author Gautam Soni
 * @version 7/31/2024
 */
public class GroundSpace implements GroundSpaces {
    // Fields
    private HashMap<String, Plane> groundspace; // hashmap that stores all the planes
    private boolean groundspaceOpen; // boolean to hold the status of whether the groundspace is open or not

    /**
     * Create a new groundspace Object.
     */
    public GroundSpace() {
        groundspace =  new HashMap<String, Plane>();
        groundspaceOpen = true; // instantiate the groundspace as open
    }

    /**
     * Adds the specified plane to the groundspace if the groundspace is open
     *
     * @param p Plane to be added
     * @return true/false if plane was added to the groundspace
     */
    @Override
    public boolean addToGroundSpace(Plane p) {
        if (groundspaceOpen) {
            groundspace.put(p.getPlaneCallSign(), p);
            return true;
        }
        return false;
    }

    /**
     * Removes the specified plane from the groundspace
     *
     * @param p Plane to be removed
     * @return true/false if plane was removed from the groundspace
     */
    @Override
    public boolean removeFromGroundSpace(Plane p) {
        if (getPlaneInGroundSpace(p) != null) {
            groundspace.remove(p.getPlaneCallSign());
            return true;
        }
        return false;
    }

    /**
     * Getter method for the specified plane in groundspace
     *
     * @param p Plane to search for in groundspace
     * @return Plane in the groundspace
     */
    @Override
    public Plane getPlaneInGroundSpace(Plane p) {
        return groundspace.get(p.getPlaneCallSign());
    }

    /**
     * Closes the groundspace by marking the groundspaceOpen variable as false.
     */
    @Override
    public void closeGroundSpace() {
        groundspaceOpen = false;
    }

    /**
     * Opens the groundspace by marking the groundspaceOpen variable as true;
     */
    @Override
    public void openGroundSpace() {
        groundspaceOpen = true;
    }

    /**
     * Getter method for the groundspace clearance
     *
     * @return true/false if the groundspace is open
     */
    @Override
    public boolean getGroundSpaceClearance() {
        return groundspaceOpen;
    }

    /**
     * Clears the groundspace by removing all objects in the groundspace hashmap.
     *
     * @return true/false if the groundspace was cleared
     */
    @Override
    public boolean clearGroundSpace() {
        if (!groundspace.isEmpty()) {
            groundspace.clear();
            return true;
        }
        return false;
    }

    /**
     * Getter method for the groundspace size
     *
     * @return Number of planes currently in the groundspace
     */
    @Override
    public int getGroundSpaceSize() {
        return groundspace.size();
    }

    /**
     * Getter method for if the groundspace is empty
     *
     * @return true/false if the groundspace is empty
     */
    @Override
    public boolean isGroundSpaceEmpty() {
        return groundspace.isEmpty();
    }
}

