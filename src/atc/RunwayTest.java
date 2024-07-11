package atc;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gautam Soni and Arihita Dirghangi
 * @version 7/10/24
 */
public class RunwayTest {
    // fields
    private static Runway L27;
    private static Plane AI101;

    public static void setUp() {
        L27 = new Runway();
        AI101 = new Plane("AI101", "Mid air");
    }

    @Test
    public void testAddToTakeoffQueue() {
        L27.addToTakeoffQueue(AI101);
        assertEquals(AI101, L27.getTakeoffQueue());

    }
}
