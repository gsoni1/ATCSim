package atc;

/**
 * Plane class, contains all the variables related to a specific plane. Provides getter and setter methods to modify
 * plane variables.
 */
public class Plane {
    private String planeModel; // B747
    private int planeAltitude; // 39025 Ft
    private int planeSpeed; // 498 Kts
    private Double planeCoordinatesX; // 40.807756
    private Double planeCoordinatesY; // -73.961614
    private Double[] planeCoordinates; // [planeCoordinatesX, planeCoordinatesY]
    private String planeCallSign; // UAE61
    private String planeFlightNumber; // EK61
    private String planeIATATypeCode; // B77W
    private String planeRegistration; // A6-EQB
    private String planeAirline; // Qantas
    private String planeOrigin; // FRA
    private String planeDestination; // DXB
    private Double planeArrivalTime; // 7.00 (EST)
    private Double planeDepartureTime; // 14.00 (EST)
    private int planeNumberOfPassengers; // 200 passengers
    private int planeFlightTime; // 14 hrs
    private String planeStatus; // at gate/taxxing/taking off/mid air/landing/arrived at gate
    private String planeFlightStatus; // delayed,on time,

    /**
     * Create a new Plane object.
     * @param callSign assigned (Eg. AI101)
     * @param planeStatus assigned (Eg. Mid air)
     */
    public Plane(String callSign, String planeStatus) {
        planeCallSign = callSign;
    }

    public String getStatus() {
        return planeFlightStatus;
    }

    public String getPlaneCallSign() {
        return planeCallSign;
    }
}
