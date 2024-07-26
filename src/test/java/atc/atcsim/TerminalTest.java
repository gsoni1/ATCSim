package atc.atcsim;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Terminal class
 * @author Arihita Dirghangi
 * @version 7/26/24
 */

public class TerminalTest {


    private Plane AI101;
    private Plane AI102;
    private Plane AI103;


    private HashMap<String,Plane> gates;


    /**
     * Set up method for the test class
     */
    public void setUp() {
        AI101 = new Plane("AIC101", "Mid air",
                "AI101", "B77W","A6- EQB",
                "Qantas", "FRA", "DXB", 7.00,
                14.00, 200, 14,"taking off",
                "delayed");
        AI102 = new Plane("AIC102", "Mid air",
                "AI102", "B77W","A6- EQB",
                "Qantas", "FRA", "DXB", 7.00,
                14.00, 200, 14,"taking off",
                "delayed");
        AI103 = new Plane("AIC103", "Mid air",
                "AI103", "B77W","A6- EQB",
                "Qantas", "FRA", "DXB", 7.00,
                14.00, 200, 14,"taking off",
                "delayed");
        gates = new HashMap<>();
        gates.put("B-12",AI101);
        gates.put("C-11", AI102);
        Terminal terminalObject = new Terminal();
    }

    /**
     * Test method for the getPlane() method
     */
    public void testGetPlane()
    {
        Terminal terminalObject = null;
        assertEquals(terminalObject.getPlane("C-11"), AI102);
    }

    /**
     * Test method for the addGate() method to check whether it returns true correctly
     */
    public void testAddGate1()
    {
        Terminal terminalObject = null;
        assertTrue(terminalObject.addGate("A-13",AI103));
    }

    /**
     * Test method for the addGate() method to check whether it returns false correctly
     */
    public void testAddGate2()
    {
        Terminal terminalObject = null;
        assertFalse(terminalObject.addGate("B-12",AI101));
    }

    /**
     * Test method for the removeGate() method to check whether it returns true correctly
     */
    public void testRemoveGate1()
    {
        Terminal terminalObject = null;
        assertTrue(terminalObject.removeGate("B-12"));
    }

    /**
     * Test method for the removeGate() method to check whether it returns false correctly
     */
    public void testRemoveGate2()
    {
        Terminal terminalObject = null;
        assertFalse(terminalObject.removeGate("A-13"));
    }

    /**
     * Test method for the containsGate() method to check if it returns true correctly
     */
    public void testContainsGate1()
    {
        Terminal terminalObject = null;
        assertEquals(true, terminalObject.containsGate("B-12"));
    }

    /**
     * Test method for the containsGate() method to check if it returns true correctly
     */
    public void testContainsGate2()
    {
        Terminal terminalObject = null;
        assertEquals(false, terminalObject.containsGate("A-13"));
    }
}
