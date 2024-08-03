package atc.atcsim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    private Terminal four;

    /**
     * Set up method for the test class
     */
    @BeforeEach
    public void setUp() {
        AI101 = new Plane("Boeing", "AIC101", "Mid air",
                "AI101", "B77W", "A6- EQB",
                "Qantas", "FRA", "DXB", 7.00,
                14.00, 200, 14, "taking off",
                "delayed");
        AI102 = new Plane("Boeing", "AIC102", "Mid air",
                "AI102", "B77W", "A6- EQB",
                "Qantas", "FRA", "DXB", 7.00,
                14.00, 200, 14, "taking off",
                "delayed");
        four = new Terminal();
    }

    /**
     * Test method for the getPlane() method
     */
    @Test
    public void testGetPlane() {
        four.addGate("D11", AI101);
        assertEquals(four.getPlane("D11"), AI101);
    }

    /**
     * Test method for the addGate() method to check whether it returns true correctly
     */
    @Test
    public void testAddGate() {
        assertTrue(four.addGate("D11", AI101));
        assertEquals(four.getPlane("D11"), AI101);
    }

    /**
     * Test method for the addGate() method to check whether it returns false correctly
     */
    @Test
    public void testAddGateAlreadyExists() {
        assertTrue(four.addGate("D11", AI101));
        assertEquals(four.getPlane("D11"), AI101);
        assertFalse(four.addGate("D11", AI101));
    }

    /**
     * Test method for the addGate() method to check efficiency of containsPlane()
     */
    @Test
    public void testGatePlaneAlreadyExists() {
        assertTrue(four.addGate("D11", AI101));
        assertFalse(four.addGate("D12", AI101));
    }

    /**
     * Test method for the removeGate() method to check whether it returns true correctly
     */
    @Test
    public void testRemoveGate() {
        assertTrue(four.addGate("D11", AI101));
        assertTrue(four.removeGate("D11"));
        assertNull(four.getPlane("D11"));

    }

    /**
     * Test method for the removeGate() method to check whether it returns false correctly
     */
    @Test
    public void testRemoveGateDoesNotExist() {
        assertFalse(four.removeGate("D11"));
    }

    /**
     * Test method for the containsGate() method to check if it returns true correctly
     */
    @Test
    public void testContainsGate() {
        four.addGate("D11", AI101);
        assertTrue(four.containsGate("D11"));
    }

    /**
     * Test method for the containsGate() method to check if it returns true correctly
     */
    @Test
    public void testContainsGateDoesNotExist() {
        assertFalse(four.containsGate("D11"));
    }

    /**
     * Test method for containsPlane() method to check if hashmap returns
     * true correctly when plane is found at least once
     */
    @Test
    public void testContainsPlane() {
        four.addGate("D11", AI101);
        assertTrue(four.containsPlane(AI101));
    }

    /**
     * Test method for containsPlane() method to check if hashmap returns
     * false correctly when plane does not exist
     */
    @Test
    public void testContainsPlaneDoesNotExist(){
        four.addGate("D11", AI102);
        assertFalse(four.containsPlane(AI101));
    }


}

