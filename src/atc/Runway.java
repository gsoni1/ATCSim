package atc;
import java.util.*;

/**
 * The runway class is a class containing the queue for the runway and methods for landing and takeoff
 *
 * @author Gautam Soni
 * @version 7/2/2024
 */
public class Runway {
    // fields
    // private String runwayName; // 4L
    private boolean runwayIsClear; // clear if true /occupied if false
    private Queue<Plane> takeoffQueue = new LinkedList<Plane>();
    private Queue<Plane> landingQueue = new LinkedList<Plane>();

    /**
     * Creates a new runway object
     */
    public Runway() {
//        this.runwayName = runwayName;
        runwayIsClear = true;

    }

    // methods
    public void addToTakeoffQueue(Plane p) {
        takeoffQueue.add(p);
    }

    public Plane getTakeoffQueue() {
        return takeoffQueue.peek();
    }

    /**
     * Removes the specified plane from the takeoff queue, likely used for the case where there is an emergency or
     * reason to return to the gate/taxiway.
     * @param p Plane to be removed
     */
    public void removeFromTakeoffQueue(Plane p) {
        takeoffQueue.remove(p);
    }

    public void addToLandingQueue(Plane p) {
        landingQueue.add(p);
    }

    public void removeFromLandingQueue(Plane p) {
        landingQueue.remove(p);
    }

    /**
     *
     */
    public void clearForTakeoff(Plane p) {
        runwayIsClear = false; // mark runway as occupied
        takeoffQueue.remove();

    }

    public void clearForLanding(Plane p) {
        runwayIsClear = false;
        landingQueue.remove();
    }

    public boolean checkRunwayClearance() {
        return runwayIsClear;
    }

    public void closeRunway() {
        runwayIsClear = false;
    }

    public void openRunway() {
        runwayIsClear = true;
    }
}
