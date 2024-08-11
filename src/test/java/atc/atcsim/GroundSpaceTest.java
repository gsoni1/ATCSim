package atc.atcsim;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the groundspace class
 * @author Gautam Soni
 * @version 7/31/2024
 */
public class GroundSpaceTest {
    // fields
    private GroundSpace londonHeathrow;
    private Plane AI101;

    /**
     * SetUp method, initializes all the instance variables
     */
    @BeforeEach
    public void setUp() {
        londonHeathrow = new GroundSpace();
        AI101 = new Plane("groundbus", "AI101", "Mid ground","EK61",
                "B77W","A6- EQB", "Qantas",
                "FRA", "DXB", 7.00, 14.00,
                200, 14,"taking off", "delayed");
    }

    /**
     * Tests the addTogroundspace method using a plane that exists within the groundspace.
     */
    @Test
    public void testAddTogroundspaceOpen() {
        assertTrue(londonHeathrow.addToGroundSpace(AI101));
        assertEquals(AI101, londonHeathrow.getPlaneInGroundSpace(AI101));
    }

    /**
     * Tests the addTogroundspace method when the groundspace is closed, so the plane is not added.
     */
    @Test
    public void testAddTogroundspaceClosed() {
        londonHeathrow.closeGroundSpace();
        assertFalse(londonHeathrow.getGroundSpaceClearance());
        assertFalse(londonHeathrow.addToGroundSpace(AI101));
        assertNull(londonHeathrow.getPlaneInGroundSpace(AI101));
    }

    /**
     * Tests the removeFromgroundspace method using a plane that exists in the groundspace, first by adding then removing the
     * plane.
     */
    @Test
    public void testRemoveFromgroundspaceExists() {
        londonHeathrow.addToGroundSpace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInGroundSpace(AI101));
        assertTrue(londonHeathrow.removeFromGroundSpace(AI101));
        assertNotEquals(AI101, londonHeathrow.getPlaneInGroundSpace(AI101));
    }

    /**
     * Tests the removeFromgroundspace method using a plane that does not exist in the groundspace, first by adding then
     * removing the plane.
     */
    @Test
    public void testRemoveFromgroundspaceDoesNotExist() {
        assertFalse(londonHeathrow.removeFromGroundSpace(AI101));
    }

    /**
     * Tests the getPlaneIngroundspace method using a plane that doesn't exist in the groundspace.
     */
    @Test
    public void testGetPlaneIngroundspaceDoesNotExist() {
        assertNull(londonHeathrow.getPlaneInGroundSpace(AI101));
    }

    /**
     * Tests the getPlaneIngroundspace method using a plane that exists in the groundspace
     */
    @Test
    public void testGetPlaneIngroundspaceExists() {
        londonHeathrow.addToGroundSpace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInGroundSpace(AI101));
    }

    /**
     * Tests the closegroundspace method by closing the groundspace
     */
    @Test
    public void testClosegroundspace() {
        assertTrue(londonHeathrow.getGroundSpaceClearance());
        londonHeathrow.closeGroundSpace();
        assertFalse(londonHeathrow.getGroundSpaceClearance());
    }

    /**
     * Tests the opengroundspace method by closing and opening the groundspace
     */
    @Test
    public void testOpengroundspace() {
        assertTrue(londonHeathrow.getGroundSpaceClearance());
        londonHeathrow.closeGroundSpace();
        assertFalse(londonHeathrow.getGroundSpaceClearance());
        londonHeathrow.openGroundSpace();
        assertTrue(londonHeathrow.getGroundSpaceClearance());
    }

    @Test
    public void testGetgroundspaceClearance() {
        assertTrue(londonHeathrow.getGroundSpaceClearance());
        londonHeathrow.closeGroundSpace();
        assertFalse(londonHeathrow.getGroundSpaceClearance());
    }

    /**
     * Tests the cleargroundspace method using a single plane in the groundspace.
     */
    @Test
    public void testCleargroundspace() {
        londonHeathrow.addToGroundSpace(AI101);
        assertEquals(londonHeathrow.getGroundSpaceSize(), 1);
        assertTrue(londonHeathrow.clearGroundSpace());
        assertEquals(londonHeathrow.getGroundSpaceSize(), 0);
    }

    /**
     * Tests the cleargroundspace method using an empty groundspace.
     */
    @Test
    public void testCleargroundspaceEmpty() {
        assertEquals(londonHeathrow.getGroundSpaceSize(), 0);
        assertFalse(londonHeathrow.clearGroundSpace());
    }

    /**
     * Tests the getgroundspaceSize method by adding and removing a plane
     */
    @Test
    public void testGetgroundspaceSize() {
        assertEquals(londonHeathrow.getGroundSpaceSize(), 0);
        londonHeathrow.addToGroundSpace(AI101);
        assertEquals(londonHeathrow.getGroundSpaceSize(), 1);
        londonHeathrow.removeFromGroundSpace(AI101);
        assertEquals(londonHeathrow.getGroundSpaceSize(), 0);
    }

    /**
     * Tests the isgroundspaceEmpty method using an empty groundspace
     */
    @Test
    public void testIsgroundspaceEmptyTrue() {
        assertTrue(londonHeathrow.isGroundSpaceEmpty());
    }

    /**
     * Tests the isgroundspaceEmpty method using an groundspace with a single plane
     */
    @Test
    public void testIsgroundspaceEmptyFalse() {
        londonHeathrow.addToGroundSpace(AI101);
        assertFalse(londonHeathrow.isGroundSpaceEmpty());
    }
}

