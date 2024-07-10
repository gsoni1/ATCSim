package atc;

/**
 * Plane class, contains all the variables related to a specific plane. Provides getter and setter methods to modify and
 * access plane variables.
 */
public class Plane {
    private String planeModel;
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
        planeFlightStatus = planeStatus;
    }

    /**
     * Getter method for variable planeFlightStatus
     * @return String indicating whether flight is delayed, on time, etc.
     */
    public String getPlaneFlightStatus() {
        return planeFlightStatus;
    }

    /**
     * Getter method for variable planeCallSign
     * @return String name of the flight called
     */
    public String getPlaneCallSign() {
        return planeCallSign;
    }
    /**
     * Getter method for variable planeModel
     * @return Plane Model type
     */
    public String getPlaneModel()
    {
        return planeModel;
    }

    /**
     * Getter method for variable planeAltitude
     * @return altitude of the plane in feet
     */
    public int getPlaneAltitude()
    {
        return planeAltitude;
    }

    /**
     * Getter method for variable planeSpeed
     * @return speed of the plane in Kts
     */
    public int getPlaneSpeed()
    {
        return planeSpeed;
    }

    /**
     * Getter method for variable planeCoordinatesX
     * @return x coordinates of the plane
     */
    public Double getPlaneCoordinatesX()
    {
        return planeCoordinatesX;
    }

    /**
     * Getter method for variable planeCoordinatesY
     * @return y coordinates of the plane
     */
    public Double getPlaneCoordinatesY()
    {
        return planeCoordinatesY;
    }

    /**
     * Getter method for variable planeCoordinates
     * @return array with x and y coordinates as [planeCoordinatesX, planeCoordinatesY]
     */
    public Double getPlaneCoordinates()
    {
//        return planeCoordinates[planeCoordinatesX, planeCoordinatesY];
        return 0.0;
    }

    /**
     * Getter method for variable planeFlightNumber
     * @return string of the flight number
     */
    public String getPlaneFlightNumber()
    {
        return planeFlightNumber;
    }

    /**
     * Getter method for variable planeIATATypeCode
     * @return the IATA Type Code as a string
     */
    public String planeIATATypeCode()
    {
        return planeIATATypeCode;
    }

    /**
     * Getter method for variable planeRegistration
     * @return the plane registration code as a string
     */
    public String planeRegistration()
    {
        return planeRegistration;
    }

    /**
     * Getter method for variable planeAirline
     * @return the plane airline as a string
     */
    public String getPlaneAirline()
    {
        return planeAirline;
    }

    /**
     * Getter method for the variable planeOrigin
     * @return the plane origin as a string
     */
    public String getPlaneOrigin()
    {
        return planeOrigin;
    }

    /**
     * Getter method for variable planeDestination
     * @return the destination of the plane
     */
    public String getPlaneDestination()
    {
        return planeDestination;
    }

    /**
     * Getter method for variable planeArrivalTime
     * @return the arrival time of the plane
     */
    public Double getPlaneArrivalTime()
    {
        return planeArrivalTime;
    }

    /**
     * Getter method for variable planeDepartureTime
     * @return the departure time of the plane with the time zone
     */
    public Double getPlaneDepartureTime()
    {
        return planeDepartureTime;
    }

    /**
     * Getter method for variable planeNumberOfPassengers
     * @return the number of passengers expected/ onboarded on flight
     */
    public int getPlaneNumberOfPassengers()
    {
        return planeNumberOfPassengers;
    }

    /**
     * Getter method for variable planeFlightTime
     * @return the expected duration of flight
     */
    public int getPlaneFlightTime()
    {
        return planeFlightTime;
    }

    /**
     * Getter method for variable planeStatus
     * @return information about whether flight is at gate/taxxing/taking off/mid air/landing/arrived at gate
     */
    public String getPlaneStatus()
    {
        return planeStatus;
    }
}
