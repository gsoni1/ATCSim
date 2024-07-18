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
    private Airspace londonHeathrow;
    private Plane AI101;

    /**
     * SetUp method, initializes all the instance variables
     */
    @BeforeEach
    public void setUp() {
        londonHeathrow = new Airspace();
        AI101 = new Plane("AI101", "Mid air");
    }

    /**
     * Tests the addToAirspace method using a plane that exists within the airspace.
     */
    @Test
    public void testAddToAirspaceOpen() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the addToAirspace method when the airspace is closed, so the plane is not added.
     */
    @Test
    public void testAddToAirspaceClosed() {
        londonHeathrow.closeAirspace();
        londonHeathrow.addToAirspace(AI101);
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the removeFromAirspace method using a plane that exists in the airspace, first by adding then removing the
     * plane.
     */
    @Test
    public void testRemoveFromAirspaceExists() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
        londonHeathrow.removeFromAirspace(AI101);
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the removeFromAirspace method using a plane that does not exist in the airspace, first by adding then
     * removing the plane.
     */
    @Test
    public void testRemoveFromAirspaceDoesNotExist() {
        londonHeathrow.removeFromAirspace(AI101);
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
        assertNull(londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the getPlaneInAirspace method using a plane that doesn't exist in the airspace.
     */
    @Test
    public void testGetPlaneInAirspaceDoesNotExist() {
        assertNull(londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the getPlaneInAirspace method using a plane that exists in the airspace
     */
    @Test
    public void testGetPlaneInAirspaceExists() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the clearAirspace method using a single plane in the airspace.
     */
    @Test
    public void testClearAirspace() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(londonHeathrow.getAirspaceCapacity(), 1);
        londonHeathrow.clearAirspace();
        assertEquals(londonHeathrow.getAirspaceCapacity(), 0);
    }

    /**
     * Tests the openAirspace method by closing and opening the airspace
     */
    @Test
    public void testOpenAirspace() {
        assertTrue(londonHeathrow.getAirspaceClearance());
        londonHeathrow.closeAirspace();
        assertFalse(londonHeathrow.getAirspaceClearance());
        londonHeathrow.openAirspace();
        assertTrue(londonHeathrow.getAirspaceClearance());
    }

    /**
     * Tests the closeAirspace method by closing the airspace
     */
    public void testCloseAirspace() {
        londonHeathrow.closeAirspace();
        assertFalse(londonHeathrow.getAirspaceClearance());
    }

    /**
     * Tests the getAirspaceCapacity method
     */
    @Test
    public void testGetAirspaceCapacity() {
        assertEquals(londonHeathrow.getAirspaceCapacity(), 0);
        londonHeathrow.addToAirspace(AI101);
        assertEquals(londonHeathrow.getAirspaceCapacity(), 1);
    }
}