package atc.atcsim;


import java.util.*;

/**
 * The runway class is a class containing the queue for the runway and methods for landing and takeoff
 *
 * @author Gautam Soni
 * @version 7/2/2024
 */
public class Runway {
    // Fields
    private Airspace airspace;
    private GroundSpace groundSpace;
    private String runwayName;
    private boolean runwayIsClear; // clear if true /occupied if false
    private Queue<Plane> takeoffQueue;
    private Queue<Plane> landingQueue;

    /**
     * Creates a new runway object
     */
    public Runway(String runwayName, Airspace airspace, GroundSpace groundSpace) {
        this.airspace = airspace;
        this.groundSpace = groundSpace;
        runwayIsClear = true;
        this.runwayName = runwayName;
        takeoffQueue = new LinkedList<Plane>();
        landingQueue = new LinkedList<Plane>();
    }

    // methods

    /**
     * Adds the specified plane to the takeoff queue, if it hasn't already been added.
     * @param p Plane to be added
     * @return true/false if plane was successfully added to the takeoff queue
     */
    public boolean addToTakeoffQueue(Plane p) {
        if (!getTakeoffQueue(p)) {
            takeoffQueue.add(p);
            return true;
        }
        return false;
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
     * @return true/false if the plane was successfully removed from the takeoff queue
     */
    public boolean removeFromTakeoffQueue(Plane p) {
        if (getTakeoffQueue(p)) {
            takeoffQueue.remove(p);
            return true;
        }
        return false;
    }

    /**
     * Removes the plane at the front of the takeoff queue.
     * @return true/false if the plane was successfully removed from the takeoff queue
     */
    public boolean removeFromTakeoffQueue() {
        if (getTakeoffQueue() != null) {
            takeoffQueue.remove();
            return true;
        }
        return false;
    }

    /**
     * Getter method for the size of the takeoff queue.
     * @return number of planes in the takeoff queue.
     */
    public int getTakeoffQueueSize() {
        return takeoffQueue.size();
    }

    /**
     * Clears the plane for takeoff, removes it from the takeoff queue, adds it to the airspace, and removes it from the
     * groundspace.
     * @param p Plane to be cleared
     */
    public boolean clearForTakeoff(Plane p) {
        if (runwayIsClear) {
            runwayIsClear = false; // mark runway as occupied until the plane leaves the runway
            takeoffQueue.remove();
            groundSpace.removeFromGroundSpace(p);
            p.setPlaneStatus("Takeoff");
            airspace.addToAirspace(p);
            p.setPlaneStatus("Cruising");
            p.setPlaneSpaceLocation("In Airspace");
            runwayIsClear = true; // mark runway as clear once the plane leaves the runway
            return true;
        }
        return false;
    }

    /**
     * Adds the specified plane to the landing queue, in preparation to land soon.
     * @param p Plane to be removed
     * @return true/false if the plane was added to the landing queue
     */
    public boolean addToLandingQueue(Plane p) {
        if (!getLandingQueue(p)) {
            landingQueue.add(p);
            return true;
        }
        return false;
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
     * @return true/false if the plane was added to the landing queue
     */
    public boolean removeFromLandingQueue(Plane p) {
        if (getLandingQueue(p)) {
            landingQueue.remove(p);
            return true;
        }
        return false;
    }

    /**
     * Removes the plane at the front of the landing queue.
     */
    public boolean removeFromLandingQueue() {
        if (getLandingQueue() != null) {
            landingQueue.remove();
            return true;
        }
        return false;
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
     * Clears the plane for landing, removes it from the landing queue, removes it from the airspace, and adds it to the
     * groundspace.
     * @param p Plane to be cleared
     * @return true/false if the plane successfully landed
     */
    public boolean clearForLanding(Plane p) {
        if (runwayIsClear) {
            runwayIsClear = false; // mark runway as occupied
            p.setPlaneStatus("Landing");
            landingQueue.remove();
            airspace.removeFromAirspace(p);
            groundSpace.addToGroundSpace(p);
            runwayIsClear = true; // mark runway as clear once the plane lands
            p.setPlaneStatus("Arriving at Gate");
            p.setPlaneSpaceLocation("In Groundspace");
            return true;
        }
        return false;
    }

    /**
     * Checks the runway clearance, if it is currently occupied by a landing or taking off plane.
     * @return true/false if the runway is clear
     */
    public boolean getRunwayClearance() {
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
