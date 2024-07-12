package atc.atcsim;

import atc.atcsim.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Airspace class
 * @author Gautam Soni
 * @version 7/10/2024
 */
public class AirspaceTest {
    // fields
    private static Airspace londonHeathrow;
    private static Plane AI101;

    /**
     * SetUp method, initializes all the instance variables
     */
    @BeforeAll
    public static void setUp() {
        londonHeathrow = new Airspace();
        AI101 = new Plane("AI101", "Mid air");
    }
    /**
     * Tests the addToAirspace method using a plane that exists within the airspace.
     * This covers the case of a plane entering the airspace.
     */
    @Test
    public void testAddToAirspace() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the removeFromAirspace method using a plane that exists in the airspace, first by adding then removing the
     * plane.
     * This covers the case of a plane leaving the airspace.
     */
    @Test
    public void testRemoveFromAirspace() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
        londonHeathrow.removeFromAirspace(AI101);
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the removeFromAirspace method using a plane that does not exist in the airspace, first by adding then removing the
     * plane
     * This covers the case of a plane on the ground or not in the airspace.
     */
    @Test
    public void testRemoveFromAirspace2() {
        londonHeathrow.removeFromAirspace(AI101);
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the getPlaneInAirspace method using a plane that doesn't exist in the airspace.
     * This covers the case of a plane being on the ground or not in the airspace.
     */
    @Test
    public void testGetPlaneInAirspace() {
        assertEquals(null, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the getPlaneInAirspace method using a plane that exists in the airspace
     * This covers the case of a plane being in the airspace.
     */
    @Test
    public void testGetPlaneInAirspace2() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

}