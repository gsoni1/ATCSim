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
    private Runway L27;
    private Plane AI101;
    private Airspace jfk;

    @BeforeEach
    public void setUp() {
        jfk = new Airspace();
        L27 = new Runway("twenty seven left", jfk);
        AI101 = new Plane("AIC101", "Mid air", 39025,498,"AI101", "B77W","A6- EQB", "Qantas", "FRA", "DXB", 7.00, 14.00, 200, 14,"taking off", "delayed");
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
        jfk.addToAirspace(AI101);
        L27.addToLandingQueue(AI101);
        assertEquals(AI101, jfk.getPlaneInAirspace(AI101));
        L27.clearForLanding(AI101);
        assertNull(jfk.getPlaneInAirspace(AI101));
    }

    @Test
    public void testGetTakeoffQueueSize() {
        assertEquals(L27.getTakeoffQueueSize(), 0);
        L27.addToTakeoffQueue(AI101);
        assertEquals(L27.getTakeoffQueueSize(), 1);
    }

    @Test
    public void testGetlandingQueueSize() {
        assertEquals(L27.getLandingQueueSize(), 0);
        jfk.addToAirspace(AI101);
        L27.addToLandingQueue(AI101);
        assertEquals(L27.getLandingQueueSize(), 1);
    }
}