package atc.atcsim;


import java.util.*;

/**
 * The runway class is a class containing the queue for the runway and methods for landing and takeoff
 *
 * @author Gautam Soni
 * @version 7/2/2024
 */
public class Runway {
    // fields
    private Airspace airspace;
    private String runwayName;
    private boolean runwayIsClear; // clear if true /occupied if false
    private Queue<Plane> takeoffQueue;
    private Queue<Plane> landingQueue;

    /**
     * Creates a new runway object
     */
    public Runway(String runwayName, Airspace airspace) {
//        airspace = new Airspace();
        this.airspace = airspace;
        runwayIsClear = true;
        this.runwayName = runwayName;
        takeoffQueue = new LinkedList<Plane>();
        landingQueue = new LinkedList<Plane>();

    }

    // methods
    public void addToTakeoffQueue(Plane p) {
        if (!getTakeoffQueue(p)) {
            takeoffQueue.add(p);
        }
    }

    /**
     * Returns if a plane is already in the takeoff queue, prevents duplicate entries. Overloaded method.
     * @param p Plane to be checked
     * @return true/false if plane is in takeoff queue
     */
    public boolean getTakeoffQueue(Plane p) {
        return takeoffQueue.contains(p);
    }

    /**
     * Returns the first plane in line in the takeoff queue.
     * @return first entry in the takeoff queue
     */
    public Plane getTakeoffQueue() {
        return takeoffQueue.peek();
    }

    /**
     * Removes the specified plane from the takeoff queue, likely used for the case where there is an emergency or
     * reason to return to the gate/taxiway.
     * @param p Plane to be removed
     */
    public void removeFromTakeoffQueue(Plane p) {
        if (getTakeoffQueue(p)) {
            takeoffQueue.remove(p);
        }
    }

    /**
     * Removes the plane at the front of the takeoff queue.
     */
    public void removeFromTakeoffQueue() {
        takeoffQueue.remove();
    }

    /**
     * Getter method for the size of the takeoff queue.
     * @return number of planes in the takeoff queue.
     */
    public int getTakeoffQueueSize() {
        return takeoffQueue.size();
    }
    /**
     * Adds the specified plane to the landing queue, in preparation to land soon.
     * @param p Plane to be removed
     */
    public void addToLandingQueue(Plane p) {
        if (!getLandingQueue(p)) {
            landingQueue.add(p);
        }
    }

    /**
     * Getter method for the size of the landing queue.
     * @return number of planes in the landing queue.
     */
    public int getLandingQueueSize() {
        return landingQueue.size();
    }

    /**
     * Removes the specified plane from the landing queue, used after the plane successfully lands.
     * @param p Plane to be removed
     */
    public void removeFromLandingQueue(Plane p) {
        if (getLandingQueue(p)) {
            landingQueue.remove(p);
        }
    }

    /**
     * Removes the plane at the front of the landing queue.
     */
    public void removeFromLandingQueue() {
        landingQueue.remove();
    }

    /**
     * Returns if a plane is already in the landing queue, prevents duplicate entries. Overloaded method.
     * @param p Plane to be checked
     * @return true/false if plane is in landing queue
     */
    public boolean getLandingQueue(Plane p) {
        return landingQueue.contains(p);
    }

    /**
     * Returns the first plane in line in the landing queue.
     * @return first entry in the landing queue
     */
    public Plane getLandingQueue() {
        return landingQueue.peek();
    }

    /**
     * Clears the plane for takeoff, removes it from the takeoff queue, adds it to the airspace, and removes it from the
     * groundspace.
     * @param p Plane to be cleared
     */
    public void clearForTakeoff(Plane p) {
        if (runwayIsClear) {
            runwayIsClear = false; // mark runway as occupied
            takeoffQueue.remove();
//            groundspace.removeFromGroundspace(p);
            airspace.addToAirspace(p);
            runwayIsClear = true; // mark runway as clear once the plane takes off
        }
    }

    /**
     * Clears the plane for landing, removes it from the landing queue, removes it from the airspace, and adds it to the
     * groundspace.
     * @param p Plane to be cleared
     */
    public void clearForLanding(Plane p) {
        if (runwayIsClear) {
            runwayIsClear = false; // mark runway as occupied
            landingQueue.remove();
            airspace.removeFromAirspace(p);
//            groundspace.addToGroundspace(p);
            runwayIsClear = true; // mark runway as clear once the plane lands
        }
    }

    /**
     * Checks the runway clearance, if it is currently occupied by a landing or taking off plane.
     * @return true/false if the runway is clear
     */
    public boolean checkRunwayClearance() {
        return runwayIsClear;
    }

    /**
     * Closes the runway, marking it as occupied to prevent unwanted landings or takeoffs.
     */
    public void closeRunway() {
        runwayIsClear = false;
    }

    /**
     * Opens the runway, marking it as clear to allow for landings and takeoffs to resume.
     */
    public void openRunway() {
        runwayIsClear = true;
    }
}
