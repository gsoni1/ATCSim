package atc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
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
     * Tests the addToAirspace method using a plane that exists within the airspace
     */
    @Test
    public void testAddToAirspace() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the removeFromAirspace method using a plane that exists in the airspace, first by adding then removing the
     * plane
     */
    @Test
    public void testRemoveFromAirspace() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
        londonHeathrow.removeFromAirspace(AI101);
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the getPlaneInAirspace method using a plane that wasn't added to the airspace
     * (this covers the case of a plane being parked/off/in maintainance/not in this airport's airspace)
     */
    @Test
    public void testGetPlaneInAirspace() {
        assertNotEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

}