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
    private String runwayName; // 4L
    private boolean runwayClearance; // clear if true /occupied if false
    private Queue<Plane> takeoffQueue = new LinkedList<Plane>();
    private Queue<Plane> landingQueue = new LinkedList<Plane>();

    /**
     * Creates a new runway object
     */
    public Runway(String runwayName) {
        this.runwayName = runwayName;
        runwayClearance = true;
    }

    // methods
    public void addToTakeoffQueue(Plane p) {
        takeoffQueue.add(p);
    }

    /**
     *
     */
    public void clearForTakeoff(Plane p) {
        runwayClearance = true; // mark runway as occupied
        takeoffQueue.remove();

    }

    public boolean checkRunwayClearance() {
        return runwayClearance;
    }


}
