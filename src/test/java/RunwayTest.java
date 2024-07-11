import org.example.Airspace;
import org.example.Plane;
import org.example.Runway;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gautam Soni
 * @version 7/10/24
 */
public class RunwayTest {
    // fields
    private static Runway L27;
    private static Plane AI101;

    @BeforeAll
    public static void setUp() {
        L27 = new Runway("twenty seven left");
        AI101 = new Plane("AI101", "Mid air");
    }

    @Test
    public void testAddToTakeoffQueue() {
        L27.addToTakeoffQueue(AI101);
        assertEquals(L27.getTakeoffQueue(), AI101);

    }
}
