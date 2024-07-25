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

    ArrayList<Plane> gates = new ArrayList<Plane>();

    //methods to add, remove, search objects from the ArrayList

    /**
     * Method that takes a plane object and adds it to the gate
     * @param p is the object to be added
     */
    public void addGate(Plane p)
    {
        gates.add(p);
    }

    /**
     * Method that remove's the gate for a cancelled or postponed flight
     * @param p is the plane object being removed
     */
    public void removeGate(Plane p)
    {
        gates.remove(p);
    }

    /**
     * Method to check if plane object exists in the Gates Arraylist
     * @param p is the plane object being searched for
     * @return boolean indicating whether the object has a Gate or not
     */
    public boolean containsGate(Plane p)
    {
        for(int i = 0; i < gates.size(); i++)
        {
            if(gates.get(i) == p)
            {
                return true;
            }
        }
        return false;
    }
}
