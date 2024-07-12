package atc.atcsim;

/**
 *
 * @author Gautam Soni and Arihita Dirghangi
 * @version 7/10/2024
 */
public class AtcController {
    public AtcController() {
        AtcControllerGUI gui = new AtcControllerGUI();
        Plane EK71 = new Plane("EK61", "midair"); // in the final version we can load chunks of
        // runways and planes and etc for usage, there can be multiple profiles, for example by airport like jfk,lax,dxb
        Airspace jfk = new Airspace();
        Runway R27 = new Runway("twenty seven right", jfk);
    }

}
