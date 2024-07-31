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
    private Plane AI102;
    private Airspace jfk;
    private GroundSpace jfkGround;

    @BeforeEach
    public void setUp() {
        jfk = new Airspace();
        jfkGround = new GroundSpace();
        L27 = new Runway("twenty seven left", jfk, jfkGround);
        AI101 = new Plane("Boeing", "AIC101", "Mid air",
                "AI101", "B77W","A6- EQB",
                "Qantas", "FRA", "DXB", 7.00,
                14.00, 200, 14,"taking off",
                "747");
        AI102 = new Plane("Boeing", "AIC102", "Mid air",
                "AI102", "B77W","A6- EQB",
                "Qantas", "FRA", "DXB", 7.00,
                14.00, 200, 14,"taking off",
                "757");
    }

    /**
     * Tests the addToTakeoffQueue method using a plane that doesn't already exist in the queue
     */
    @Test
    public void testAddToTakeoffQueue() {
        assertTrue(L27.addToTakeoffQueue(AI101));
        assertTrue(L27.getTakeoffQueue(AI101));
    }

    /**
     * Tests the addToTakeoffQueue method using a plane that already exists in the queue
     */
    @Test
    public void testAddToTakeoffQueueAlreadyExists() {
        assertTrue(L27.addToTakeoffQueue(AI101));
        assertTrue(L27.getTakeoffQueue(AI101));
        assertFalse(L27.addToTakeoffQueue(AI101));
    }

    /**
     * Tests the getTakeoffQueue method using a plane that exists in the queue
     */
    @Test
    public void testGetTakeoffQueue() {
        L27.addToTakeoffQueue(AI101);
        assertTrue(L27.getTakeoffQueue(AI101));
    }

    /**
     * Tests the getTakeoffQueue method using a plane that does not exist in the queue
     */
    @Test
    public void testGetTakeoffQueueDoesNotExist() {
        assertFalse(L27.getTakeoffQueue(AI102));
    }

    /**
     * Tests the getTakeoffQueue (no parameters) using a plane that exists in the queue
     */
    @Test
    public void testGetTakeoffQueueNoParam() {
        L27.addToTakeoffQueue(AI101);
        assertEquals(L27.getTakeoffQueue(), AI101);
    }

    /**
     * Tests the getTakeoffQueue (no parameters) using a plane that does not exist in the queue
     */
    @Test
    public void testGetTakeoffQueueNoParamDoesNotExist() {
        assertNull(L27.getTakeoffQueue());
    }

    /**
     * Tests the removeFromTakeoffQueue method using a plane that does not exist in the queue
     */
    @Test
    public void testRemoveFromTakeoffQueueDoesNotExist() {
        assertFalse(L27.removeFromTakeoffQueue(AI101));
    }

    /**
     * Tests the removeFromTakeoffQueue method using a plane that exists in the queue
     */
    @Test
    public void testRemoveFromTakeoffQueue() {
        L27.addToTakeoffQueue(AI101);
        assertTrue(L27.getTakeoffQueue(AI101));
        assertTrue(L27.removeFromTakeoffQueue(AI101));
        assertFalse(L27.getTakeoffQueue(AI101));
    }

    /**
     * Tests the removeFromTakeoffQueue (no parameters) method using a plane that does not exist in the queue
     */
    @Test
    public void testRemoveFromTakeoffQueueNoParamDoesNotExist() {
        assertFalse(L27.removeFromTakeoffQueue());
    }

    /**
     * Tests the removeFromTakeoffQueue (no parameters) method using a plane that exists in the queue
     */
    @Test
    public void testRemoveFromTakeoffQueueNoParam() {
        L27.addToTakeoffQueue(AI101);
        assertTrue(L27.getTakeoffQueue(AI101));
        assertTrue(L27.removeFromTakeoffQueue());
        assertNull(L27.getTakeoffQueue());
    }

    /**
     * Tests the getTakeoffQueueSize method using a plane that exists in the queue
     */
    @Test
    public void testGetTakeoffQueueSize() {
        assertEquals(L27.getTakeoffQueueSize(), 0);
        assertNull(L27.getTakeoffQueue());
        L27.addToTakeoffQueue(AI101);
        assertTrue(L27.getTakeoffQueue(AI101));
        assertEquals(L27.getTakeoffQueueSize(), 1);
    }

    /**
     * Tests the clearForTakeoff method using a plane that exists in the queue
     */
    @Test
    public void testClearForTakeoff() {
        L27.addToTakeoffQueue(AI101);
        assertTrue(L27.getTakeoffQueue(AI101));
        L27.clearForTakeoff(AI101);
        assertNull(L27.getTakeoffQueue());
        assertEquals(AI101, jfk.getPlaneInAirspace(AI101));
    }

    /**
     * Tests the clearForTakeoff method using a plane that exists in the queue but a closed runway
     */
    @Test
    public void testClearForTakeoffRunwayClosed() {
        L27.closeRunway();
        L27.addToTakeoffQueue(AI101);
        assertTrue(L27.getTakeoffQueue(AI101));
        assertFalse(L27.clearForTakeoff(AI101));
        assertTrue(L27.getTakeoffQueue(AI101));
    }

    /**
     * Tests the addToLandingQueue method using a plane that doesn't already exist in the queue
     */
    @Test
    public void testAddToLandingQueue() {
        assertTrue(L27.addToLandingQueue(AI101));
        assertTrue(L27.getLandingQueue(AI101));
    }

    /**
     * Tests the addToLandingQueue method using a plane that already exists in the queue
     */
    @Test
    public void testAddToLandingQueueAlreadyExists() {
        L27.addToLandingQueue(AI101);
        assertTrue(L27.getLandingQueue(AI101));
        assertFalse(L27.addToLandingQueue(AI101));
    }

    /**
     * Tests the getLandingQueueSize method using a plane that exists in the queue
     */
    @Test
    public void testGetLandingQueueSize() {
        assertEquals(L27.getLandingQueueSize(), 0);
        assertNull(L27.getLandingQueue());
        L27.addToLandingQueue(AI101);
        assertTrue(L27.getLandingQueue(AI101));
        assertEquals(L27.getLandingQueueSize(), 1);
    }

    /**
     * Tests the removeFromLandingQueue method using a plane that does not exist in the queue
     */
    @Test
    public void testRemoveFromLandingQueueDoesNotExist() {
        assertFalse(L27.removeFromLandingQueue(AI101));
    }

    /**
     * Tests the removeFromLandingQueue method using a plane that exists in the queue
     */
    @Test
    public void testRemoveFromLandingQueue() {
        L27.addToLandingQueue(AI101);
        assertTrue(L27.getLandingQueue(AI101));
        assertTrue(L27.removeFromLandingQueue(AI101));
        assertNull(L27.getLandingQueue());
    }

    /**
     * Tests the removeFromLandingQueue (no parameters) method using a plane that exists in the queue
     */
    @Test
    public void testRemoveFromLandingQueueNoParam() {
        L27.addToLandingQueue(AI101);
        assertTrue(L27.getLandingQueue(AI101));
        assertTrue(L27.removeFromLandingQueue());
        assertNull(L27.getLandingQueue());
    }

    /**
     * Tests the removeFromLandingQueue (no parameters) method using a plane that does not exist in the queue
     */
    @Test
    public void testRemoveFromLandingQueueNoParamDoesNotExist() {
        assertFalse(L27.removeFromLandingQueue());
    }

    /**
     * Tests the getLandingQueue method with a plane that exists in the landing queue
     */
    @Test
    public void testGetLandingQueue() {
        L27.addToLandingQueue(AI101);
        assertTrue(L27.getLandingQueue(AI101));
    }

    /**
     * Tests the getLandingQueue method using a plane that does not exist in the queue
     */
    @Test
    public void testGetLandingQueueDoesNotExist() {
        assertFalse(L27.getLandingQueue(AI101));
    }

    /**
     * Tests the getLandingQueue (no parameters) method with a plane that exists in the landing queue
     */
    @Test
    public void testGetLandingQueueNoParam() {
        L27.addToLandingQueue(AI101);
        assertEquals(L27.getLandingQueue(), AI101);
    }

    /**
     * Tests the getLandingQueue (no parameters) method using a plane that does not exist in the queue
     */
    @Test
    public void testGetLandingQueueNoParamDoesNotExist() {
        assertNull(L27.getLandingQueue());
    }

    /**
     * Tests the clearForLanding method using a plane that exists in the queue
     */
    @Test
    public void testClearForLanding() {
        jfk.addToAirspace(AI101);
        L27.addToLandingQueue(AI101);
        assertTrue(L27.getLandingQueue(AI101));
        assertTrue(L27.clearForLanding(AI101));
        assertNull(L27.getLandingQueue());
    }

    /**
     * Tests the clearForLanding method using a plane that exists in the queue but a closed runway
     */
    @Test
    public void testClearForLandingRunwayClosed() {
        jfk.addToAirspace(AI101);
        L27.addToLandingQueue(AI101);
        assertTrue(L27.getLandingQueue(AI101));
        L27.closeRunway();
        assertFalse(L27.clearForLanding(AI101));
        assertTrue(L27.getLandingQueue(AI101));
    }

    /**
     * Tests the getRunwayClearance method with an open runway
     */
    @Test
    public void testGetRunwayClearance() {
        assertTrue(L27.getRunwayClearance());
    }

    /**
     * Tests the getRunwayClearance method with a closed runway
     */
    @Test
    public void testGetRunwayClearanceRunwayClosed() {
        L27.closeRunway();
        assertFalse(L27.getRunwayClearance());
    }

    /**
     * Tests the closeRunway method
     */
    @Test
    public void testCloseRunway() {
        assertTrue(L27.getRunwayClearance());
        L27.closeRunway();
        assertFalse(L27.getRunwayClearance());
    }

    /**
     * Tests the openRunway method
     */
    @Test
    public void testOpenRunway() {
        assertTrue(L27.getRunwayClearance());
        L27.closeRunway();
        assertFalse(L27.getRunwayClearance());
        L27.openRunway();
        assertTrue(L27.getRunwayClearance());
    }
}