package atc.atcsim;
import java.util.*;


/**
 * The Terminal class is a class that holds gates for that given terminal, which in turn, holds all the parked planes,
 * passengers, etc.
 *
 * @author Arihita Dirghangi
 * @version 7/10/24
 */
public class Terminal {

    HashMap<String, Plane> gates = new HashMap<>();

    /**
     * Method that takes a plane object and adds it to the gate
     * @param p is the object to be added
     * @param gateName is the string name of the gate, Eg:- 14D
     */
    public void addGate(String gateName, Plane p)
    {
        if(!containsGate(gateName)) {
            gates.put(gateName, p);
        }
    }

    /**
     * Method that remove's the gate for a cancelled or postponed flight
     * @param gateName is the gate being removed
     */
    public void removeGate(String gateName)
    {
        gates.remove(gateName);
    }

    /**
     * Method to check if plane object exists in the Gates Arraylist
     * @param gateName is the gate name being searched for
     * @return boolean indicating whether the object has a Gate or not
     */
    public boolean containsGate(String gateName)
    {
        if (gates.containsKey(gateName))
        {
            return true;
        }
        return false;
    }
}
