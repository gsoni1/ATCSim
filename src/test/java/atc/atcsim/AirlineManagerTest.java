package atc.atcsim;

import atc.atcsim.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class AirlineManagerTest {
    // fields
    private AirlineManager SingaporeAirlines;
    private Plane SQ11;

    /**
     * SetUp method, initializes all the instance variables
     */
    @BeforeEach
    public void setUp() {
    SingaporeAirlines = new AirlineManager();
    SQ11 = new Plane("Boeing", "SIA11", "Mid air","SQ11",
            "B77W","9V-SWB", "SingaporeAirlines",
            "FRA", "DXB", 1.15, 7.00,
            200, 14,"taking off", "B777");
    }

    @Test
    public void testAddPlaneToFleet() {
        assertTrue(SingaporeAirlines.addPlaneToFleet(SQ11));
        assertTrue(SingaporeAirlines.doesPlaneExistInFleet(SQ11));
//        assertEquals(SQ11, SingaporeAirlines.getPlaneInFleet(SQ11));
    }

    @Test
    public void testAddPlaneToFleetExists() {
        SingaporeAirlines.addPlaneToFleet(SQ11);
        assertTrue(SingaporeAirlines.doesPlaneExistInFleet(SQ11));
        assertFalse(SingaporeAirlines.addPlaneToFleet(SQ11));
    }

    @Test
    public void testDoesPlaneExistInFleet() {
        assertFalse(SingaporeAirlines.doesPlaneExistInFleet(SQ11));
        SingaporeAirlines.addPlaneToFleet(SQ11);
        assertTrue(SingaporeAirlines.doesPlaneExistInFleet(SQ11));
    }

    @Test
    public void testRemovePlaneFromFleet() {
        SingaporeAirlines.addPlaneToFleet(SQ11);
        assertTrue(SingaporeAirlines.doesPlaneExistInFleet(SQ11));
        assertTrue(SingaporeAirlines.removePlaneFromFleet(SQ11));
        assertFalse(SingaporeAirlines.doesPlaneExistInFleet(SQ11));
    }

    @Test
    public void testRemovePlaneFromFleetDoesNotExist() {
        assertFalse(SingaporeAirlines.doesPlaneExistInFleet(SQ11));
        assertFalse(SingaporeAirlines.removePlaneFromFleet(SQ11));
    }

    @Test
    public void testGetNumOfAllPlanes() {
        assertEquals(0, SingaporeAirlines.getNumOfAllPlanes());
        SingaporeAirlines.addPlaneToFleet(SQ11);
        assertEquals(1, SingaporeAirlines.getNumOfAllPlanes());
        SingaporeAirlines.removePlaneFromFleet(SQ11);
        assertEquals(0, SingaporeAirlines.getNumOfAllPlanes());
    }

    @Test
    public void testGetNumOfPlaneModel() {
        assertEquals(0, SingaporeAirlines.getNumOfPlaneModel("B777"));
        SingaporeAirlines.addPlaneToFleet(SQ11);
        assertEquals(1, SingaporeAirlines.getNumOfPlaneModel("B777"));
        SingaporeAirlines.removePlaneFromFleet(SQ11);
        assertEquals(0, SingaporeAirlines.getNumOfPlaneModel("B777"));

    }

    @Test
    public void testGetNumOfPlaneManufacturer() {
        assertEquals(0, SingaporeAirlines.getNumOfPlaneManufacturer("Boeing"));
        SingaporeAirlines.addPlaneToFleet(SQ11);
        assertEquals(1, SingaporeAirlines.getNumOfPlaneManufacturer("Boeing"));
        SingaporeAirlines.removePlaneFromFleet(SQ11);
        assertEquals(0, SingaporeAirlines.getNumOfPlaneManufacturer("Boeing"));
    }

    @Test
    public void testClearFleet() {
        assertTrue(SingaporeAirlines.isFleetEmpty());
        SingaporeAirlines.addPlaneToFleet(SQ11);
        assertFalse(SingaporeAirlines.isFleetEmpty());
//        assertTrue(SingaporeAirlines.clearFleet());
        assertTrue(SingaporeAirlines.isFleetEmpty());
    }
}