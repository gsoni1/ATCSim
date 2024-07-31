package atc.atcsim;
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
        AI101 = new Plane("Airbus", "AI101", "Mid air","EK61",
                "B77W","A6- EQB", "Qantas",
                "FRA", "DXB", 7.00, 14.00,
                200, 14,"taking off", "delayed");
    }

    /**
     * Tests the addToAirspace method using a plane that exists within the airspace.
     */
    @Test
    public void testAddToAirspaceOpen() {
        assertTrue(londonHeathrow.addToAirspace(AI101));
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the addToAirspace method when the airspace is closed, so the plane is not added.
     */
    @Test
    public void testAddToAirspaceClosed() {
        londonHeathrow.closeAirspace();
        assertFalse(londonHeathrow.getAirspaceClearance());
        assertFalse(londonHeathrow.addToAirspace(AI101));
        assertNull(londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the removeFromAirspace method using a plane that exists in the airspace, first by adding then removing the
     * plane.
     */
    @Test
    public void testRemoveFromAirspaceExists() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
        assertTrue(londonHeathrow.removeFromAirspace(AI101));
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the removeFromAirspace method using a plane that does not exist in the airspace, first by adding then
     * removing the plane.
     */
    @Test
    public void testRemoveFromAirspaceDoesNotExist() {
        assertFalse(londonHeathrow.removeFromAirspace(AI101));
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
     * Tests the closeAirspace method by closing the airspace
     */
    @Test
    public void testCloseAirspace() {
        assertTrue(londonHeathrow.getAirspaceClearance());
        londonHeathrow.closeAirspace();
        assertFalse(londonHeathrow.getAirspaceClearance());
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

    @Test
    public void testGetAirspaceClearance() {
        assertTrue(londonHeathrow.getAirspaceClearance());
        londonHeathrow.closeAirspace();
        assertFalse(londonHeathrow.getAirspaceClearance());
    }

    /**
     * Tests the clearAirspace method using a single plane in the airspace.
     */
    @Test
    public void testClearAirspace() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(londonHeathrow.getAirspaceSize(), 1);
        assertTrue(londonHeathrow.clearAirspace());
        assertEquals(londonHeathrow.getAirspaceSize(), 0);
    }

    /**
     * Tests the clearAirspace method using an empty airspace.
     */
    @Test
    public void testClearAirspaceEmpty() {
        assertEquals(londonHeathrow.getAirspaceSize(), 0);
        assertFalse(londonHeathrow.clearAirspace());
    }

    /**
     * Tests the getAirspaceSize method by adding and removing a plane
     */
    @Test
    public void testGetAirspaceSize() {
        assertEquals(londonHeathrow.getAirspaceSize(), 0);
        londonHeathrow.addToAirspace(AI101);
        assertEquals(londonHeathrow.getAirspaceSize(), 1);
        londonHeathrow.removeFromAirspace(AI101);
        assertEquals(londonHeathrow.getAirspaceSize(), 0);
    }

    /**
     * Tests the isAirspaceEmpty method using an empty airspace
     */
    @Test
    public void testIsAirspaceEmptyTrue() {
        assertTrue(londonHeathrow.isAirspaceEmpty());
    }

    /**
     * Tests the isAirspaceEmpty method using an airspace with a single plane
     */
    @Test
    public void testIsAirspaceEmptyFalse() {
        londonHeathrow.addToAirspace(AI101);
        assertFalse(londonHeathrow.isAirspaceEmpty());
    }
}