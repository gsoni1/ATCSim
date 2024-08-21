package atc.atcsim;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Plane Class
 * @author Gautam Soni and Arihita Dirghangi
 * @version 7/10/24
 */
public class PlaneTest {

    //fields
    private Plane AI101;

    /**
     * SetUp method, initializes all instance variables
     */
    @BeforeEach
    public void setup() {
        AI101 = new Plane("Airbus", "AI101", "Mid air", "EK61",
                "B77W", "A6- EQB", "Qantas",
                "FRA", "DXB", 7.00, 14.00,
                200, 14, "taking off", "B777", "airspace");
    }

    /**
     * Test the getPlaneFlightStatus() getter method
     */
    @Test
    public void testGetPlaneFlightStatus() {
        assertEquals(AI101.getPlaneFlightStatus(), "Mid air");
    }

    /**
     * Test the getPlaneCallSign() getter method
     */
    @Test
    public void testGetPlaneCallSign() {
        assertEquals(AI101.getPlaneCallSign(), "AI101");
    }

    /**
     * Test the getPlaneManufacturer() getter method
     */
    @Test
    public void testGetPlaneManufacturer() {
        assertEquals(AI101.getPlaneManufacturer(), "Airbus");
    }

    /**
     * Test the getPlaneModel() getter method
     */
    @Test
    public void testGetPlaneModel() {
        assertEquals(AI101.getPlaneModel(), "B777");
    }

    /**
     * Test the getPlaneFlightNumber() getter method
     */
    @Test
    public void testGetPlaneFlightNumber() {
        assertEquals(AI101.getPlaneFlightNumber(), "EK61");
    }

    /**
     * Test the getPlaneIATATypeCode() getter method
     */
    @Test
    public void testGetPlaneIATATypeCode() {
        assertEquals(AI101.getPlaneIATATypeCode(), "B77W");
    }

    /**
     * Test the getPlaneRegistration() getter method
     */
    @Test
    public void testGetPlaneRegistration() {
        assertEquals(AI101.getPlaneRegistration(), "A6- EQB");
    }

    /**
     * Test the getPlaneAirline() getter method
     */
    @Test
    public void testGetPlaneAirline() {
        assertEquals(AI101.getPlaneAirline(), "Qantas");
    }

    /**
     * Test the getPlaneOrigin() getter method
     */
    @Test
    public void testGetPlaneOrigin() {
        assertEquals(AI101.getPlaneOrigin(), "FRA");
    }

    /**
     * Test the getPlaneDestination() getter method
     */
    @Test
    public void testGetPlaneDestination() {
        assertEquals(AI101.getPlaneDestination(), "DXB");
    }

    /**
     * Test the getPlaneArrivalTime() getter method
     */
    @Test
    public void testGetPlaneArrivalTime() {
        assertEquals(AI101.getPlaneArrivalTime(), 7.00);
    }

    /**
     * Test the getPlaneDepartureTime() getter method
     */
    @Test
    public void testGetPlaneDepartureTime() {
        assertEquals(AI101.getPlaneDepartureTime(), 14.00);
    }

    /**
     * Test the getPlaneNumberOfPassengers() getter method
     */
    @Test
    public void testGetPlaneNumberOfPassengers() {
        assertEquals(AI101.getPlaneNumberOfPassengers(), 200);
    }

    /**
     * Test the getPlaneFlightTime() getter method
     */
    @Test
    public void testGetPlaneFlightTime() {
        assertEquals(AI101.getPlaneFlightTime(), 14);
    }

    /**
     * Test the getPlaneStatus() getter method
     */
    @Test
    public void testGetPlaneStatus() {
        assertEquals(AI101.getPlaneStatus(), "taking off");
    }

    /**
     * Test the getPlaneSpaceLocation() getter method
     */
    @Test
    public void testGetPlaneSpaceLocation() {
        assertEquals(AI101.getPlaneSpaceLocation(), "airspace");
    }

    /**
     * Test the setPlaneModel() setter method
     */
    @Test
    public void testSetPlaneModel() {
        AI101.setPlaneModel("B787");
        assertEquals(AI101.getPlaneModel(), "B787");
    }

    /**
     * Test the setPlaneMonufacturer() setter method
     */
    @Test
    public void testSetPlaneManufacturer() {
        AI101.setPlaneManufacturer("Boeing");
        assertEquals(AI101.getPlaneManufacturer(), "Boeing");
    }

    /**
     * Test the setPlaneStatus() setter method
     */
    @Test
    public void testSetPlaneStatus() {
        AI101.setPlaneStatus("landing");
        assertEquals(AI101.getPlaneStatus(), "landing");
    }

    /**
     * Test the setPlaneFlightNumber() setter method
     */
    @Test
    public void testSetPlaneFlightNumber() {
        AI101.setPlaneFlightNumber("EK237");
        assertEquals(AI101.getPlaneFlightNumber(), "EK237");
    }

    /**
     * Test the setPlaneIATATypeCode() setter method
     */
    @Test
    public void testSetPlaneIATATypeCode() {
        AI101.setPlaneIATATypeCode("B78W");
        assertEquals(AI101.getPlaneIATATypeCode(), "B78W");
    }

    /**
     * Test the setPlaneRegistration() setter method
     */
    @Test
    public void testSetPlaneRegistration() {
        AI101.setPlaneRegistration("A7- EQB");
        assertEquals(AI101.getPlaneRegistration(), "A7- EQB");
    }

    /**
     * Test the setPlaneAirline() setter method
     */
    @Test
    public void testSetPlaneAirline() {
        AI101.setPlaneAirline("Emirates");
        assertEquals(AI101.getPlaneAirline(), "Emirates");
    }

    /**
     * Test the setPlaneOrigin() setter method
     */
    @Test
    public void testSetPlaneOrigin() {
        AI101.setPlaneOrigin("DXB");
        assertEquals(AI101.getPlaneOrigin(), "DXB");
    }

    /**
     * Test the setPlaneDestination() setter method
     */
    @Test
    public void testSetPlaneDestination() {
        AI101.setPlaneDestination("HK");
        assertEquals(AI101.getPlaneDestination(), "HK");
    }

    /**
     * Test the setPlaneArrivalTime() setter method
     */
    @Test
    public void testSetPlaneArrivalTime() {
        AI101.setPlaneArrivalTime(1.00);
        assertEquals(AI101.getPlaneArrivalTime(), 1.00);
    }

    /**
     * Test the setPlaneNumberOfPassengers() setter method
     */
    @Test
    public void testSetPlaneNumberOfPassengers() {
        AI101.setPlaneNumberOfPassengers(300);
        assertEquals(AI101.getPlaneNumberOfPassengers(), 300);
    }

    /**
     * Test the setPlaneFlightTime() setter method
     */
    @Test
    public void testSetPlaneFlightTime() {
        AI101.setPlaneFlightTime(8);
        assertEquals(AI101.getPlaneFlightTime(), 8);
    }

    /**
     * Test the setPlaneFlightStatus() setter method
     */
    @Test
    public void testSetPlaneFlightStatus() {
        AI101.setPlaneFlightStatus("Landing");
        assertEquals(AI101.getPlaneFlightStatus(), "Landing");
    }

    /**
     * Test the setPlaneSpaceLocation() setter method
     */
    @Test
    public void testSetPlaneSpaceLocation() {
        AI101.setPlaneSpaceLocation("groundspace");
        assertEquals(AI101.getPlaneSpaceLocation(), "groundspace");
    }


}