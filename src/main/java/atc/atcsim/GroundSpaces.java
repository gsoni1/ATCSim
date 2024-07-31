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
    public boolean addToGroundSpace(Plane p);
    public boolean removeFromGroundSpace(Plane p);
    public Plane getPlaneInGroundSpace(Plane p);
    public void closeGroundSpace();
    public void openGroundSpace();
    public boolean getGroundSpaceClearance();
    public boolean clearGroundSpace();
    public int getGroundSpaceSize();
    public boolean isGroundSpaceEmpty();
}
