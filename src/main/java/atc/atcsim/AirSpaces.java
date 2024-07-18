package atc.atcsim;

/**
 * AirSpaces interface, declares all the methods for the Airspace class.
 *
 * @author Gautam Soni
 * @version 7/12/2024
 */
public interface AirSpaces {
    // Method Declarations
    public void addToAirspace(Plane p);
    public void removeFromAirspace(Plane p);
    public Plane getPlaneInAirspace(Plane p);
    public void closeAirspace();
    public void openAirspace();
    public boolean getAirspaceClearance();
    public void clearAirspace();
    public int getAirspaceCapacity();
}