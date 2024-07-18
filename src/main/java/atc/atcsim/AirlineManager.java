package atc.atcsim;
import java.util.*;

/**
 * The airlinemanager class is a class that airlines can use to track and manage their fleet globally, such as see where
 * each of their planes are, how many models they have, how many routes are being served, etc.
 *
 * @author Gautam Soni
 * @version 7/10/2024
 */
public class AirlineManager {
    // fields
    private String[] airlineFleet;

    public AirlineManager() {
        airlineFleet = new String[3];
        airlineFleet[0] = "Boeing";
        airlineFleet[1] = "Airbus";
        airlineFleet[2] = "Other";
    }

    public void addBoeingToFleet(String planeModel, Plane p) {
//        airlineFleet.put(planeModel, p);
    }

}
