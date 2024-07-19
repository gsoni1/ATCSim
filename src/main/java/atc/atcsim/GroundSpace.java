package atc.atcsim;
import java.util.HashMap;

/**
 * GroundSpace class, implements the GroundSpaces interface and defines all of its method, uses a hashmap to store planes in a given airspace. Provides methods to modify the contents
 * of the hashmap.
 *
 * @author Arihita Dirghangi
 * @version 7/10/2024
 */
public class GroundSpace implements GroundSpaces{

    private HashMap<String, Plane> groundSpace; // hashmap that stores all the planes
    private boolean groundSpaceOpen;

    /**
     * Create a new groundSpace Object.
     */
    public GroundSpace() {
        groundSpace =  new HashMap<String, Plane>();
        groundSpaceOpen = true; // instantiate the airspace as open
    }

    /**
     * Adds the specified plane to the groundSpace if the groundSpace is open
     * @param p Plane to be added
     */
    @Override
    public void addToGroundSpace(Plane p) {
        if (groundSpaceOpen) {
            groundSpace.put(p.getPlaneCallSign(), p);
        }
    }

    /**
     * Removes the specified plane from the groundSpace
     * @param p Plane to be removed
     */
    @Override
    public void removeFromGroundSpace(Plane p) {
        if (getPlaneInGroundSpace(p) != null) {
            groundSpace.remove(p.getPlaneCallSign());
        }
    }

    /**
     * Getter method for the specified plane in groundSpace
     * @param p Plane to search for in groundSpace
     * @return Plane in the groundSpace
     */
    @Override
    public Plane getPlaneInGroundSpace(Plane p) {
        return groundSpace.get(p.getPlaneCallSign());
    }

    /**
     * Closes the groundSpace by marking the groundSpaceOpen variable as false.
     */
    @Override
    public void closeGroundSpace() {
        groundSpaceOpen = false;
    }

    /**
     * Opens the groundSpace by marking the groundSpaceOpen variable as true;
     */
    @Override
    public void openGroundSpace() {
        groundSpaceOpen = true;
    }

    /**
     * Getter method for the groundSpace clearance
     * @return true/false if the groundSpace is open
     */
    @Override
    public boolean getGroundSpaceClearance() {
        return groundSpaceOpen;
    }

    /**
     * Clears the groundSpace by removing all objects in the groundSpace hashmap.
     */
    @Override
    public void clearGroundSpace() {
        groundSpace.clear();
    }

    /**
     * Getter method for the groundSpace capacity
     * @return Number of planes currently in the groundSpace
     */
    @Override
    public int getGroundSpaceCapacity() {
        return groundSpace.size();
    }



}
