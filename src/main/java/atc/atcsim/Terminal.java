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

    public Terminal()
    {
        this.gates = gates;
    }

    /**
     * Method that returns the plane object when the name is searched
     * @param gateName is the name of the gate
     * @return plane object for the gate name
     */
    public Plane getPlane(String gateName)
    {
        return gates.get(gateName);
    }

    /**
     * Method that takes a plane object and adds it to the gate
     * @param p is the object to be added
     * @param gateName is the string name of the gate, Eg:- 14D
     * @return boolean to indicate whether addition was successful or not
     */
    public boolean addGate(String gateName, Plane p)
    {
        if(!containsGate(gateName)) {
            gates.put(gateName, p);
            return true;
        }
        return false;
    }

    /**
     * Method that remove's the gate for a cancelled or postponed flight
     * @param gateName is the gate being removed
     * @return boolean to indicate whether remove was successful or not
     */
    public boolean removeGate(String gateName)
    {
        if(containsGate(gateName)) {
            gates.remove(gateName);
            return true;
        }
        return false;
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
