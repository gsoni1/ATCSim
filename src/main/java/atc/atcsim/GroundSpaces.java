package atc.atcsim;

/**
 *
 * GroundSpaces interface, declares all the methods for the GroundSpace class.
 *
 * @author Arihita Dirghangi
 * @version 7/10/2024
 * */

public interface GroundSpaces {

    // Method Declarations
    public void addToGroundSpace(Plane p);
    public void removeFromGroundSpace(Plane p);
    public Plane getPlaneInGroundSpace(Plane p);
    public void closeGroundSpace();
    public void openGroundSpace();
    public boolean getGroundSpaceClearance();
    public void clearGroundSpace();
    public int getGroundSpaceCapacity();
}
