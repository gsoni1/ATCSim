package atc.atcsim;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Runway class
 * @author Gautam Soni
 * @version 7/10/24
 */
public class RunwayTest {
    // fields
    private static Runway L27;
    private static Plane AI101;
    private static Airspace jfk;

    @BeforeAll
    public static void setUp() {
        jfk = new Airspace();
        L27 = new Runway("twenty seven left", jfk);
        AI101 = new Plane("AI101", "Mid air");
    }

    @Test
    public void testAddToTakeoffQueue() {
        L27.addToTakeoffQueue(AI101);
        assertEquals(L27.getTakeoffQueue(), AI101);

    }

    @Test
    public void testClearForTakeoff() {
        L27.addToTakeoffQueue(AI101);
        L27.clearForTakeoff(AI101);
        assertEquals(AI101, jfk.getPlaneInAirspace(AI101));
    }

    @Test
    public void testClearForLanding() {
        L27.addToLandingQueue(AI101);
        assertEquals(AI101, jfk.getPlaneInAirspace(AI101));
        L27.clearForLanding(AI101);
        assertNull(jfk.getPlaneInAirspace(AI101));
    }
}