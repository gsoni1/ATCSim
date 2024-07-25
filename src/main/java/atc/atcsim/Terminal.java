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
     * @param name is the string name of the gate, Eg:- 14D
     */
    public void addGate(String name, Plane p)
    {
        gates.put(name,p);
    }

    /**
     * Method that remove's the gate for a cancelled or postponed flight
     * @param name is the gate being removed
     */
    public void removeGate(String name)
    {
        gates.remove(name);
    }

    /**
     * Method to check if plane object exists in the Gates Arraylist
     * @param name is the gate name being searched for
     * @return boolean indicating whether the object has a Gate or not
     */
    public boolean containsGate(String name)
    {
        if (gates.containsKey(name))
        {
            return true;
        }
        return false;
    }
}
