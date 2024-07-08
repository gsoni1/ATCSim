package atc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirspaceTest {
    // fields
    private Airspace londonHeathrow = new Airspace();
    Plane AI101 = new Plane("AI101", "Mid air");
    @Test
    public void testAddToAirspace() {
        londonHeathrow.addToAirspace(AI101);
        assertEquals(AI101, londonHeathrow.getPlaneInAirspace(AI101));
    }

}