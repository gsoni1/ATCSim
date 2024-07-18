package atc.atcsim;


/**
 * Plane class, contains all the variables related to a specific plane. Provides getter and setter methods to modify and
 * access plane variables.
 *
 * @author Arihita Dirghangi
 * @version 7/10/2024
 */
public class Plane {
    private String planeModel;
    private int planeAltitude; // 39025 Ft
    private int planeSpeed; // 498 Kts
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
     * @param planeCallSign assigned (Eg. AI101)
     * @param planeFlightStatus assigned (Eg. delayed)
     * @param planeModel assigned
     * @param planeAltitude assigned (Eg. 30945 Ft.)
     * @param planeSpeed assigned (Eg. 498 kts)
     * @param planeFlightNumber assigned (Eg. EK61)
     * @param planeIATATypeCode assigned (Eg. B77W)
     * @param planeRegistration assigned (Eg. A6- EQB)
     * @param planeAirline assigned (Eg. Qantas)
     * @param planeOrigin assigned (Eg. FRA)
     * @param planeDestination assigned (Eg. DXB)
     * @param planeArrivalTime assigned (Eg. 7.00 EST)
     * @param planeDepartureTime assigned (Eg. 14.00 EST)
     * @param planeNumberOfPassengers assigned (Eg. 200)
     * @param planeFlightTime assigned (Eg. 14)
     * @param planeStatus assigned (Eg. taking off)
     *
     */
    public Plane(String planeCallSign, String planeFlightStatus, int planeAltitude, int planeSpeed, String planeFlightNumber, String planeIATATypeCode, String planeRegistration, String planeAirline, String planeOrigin, String planeDestination, Double planeArrivalTime, Double planeDepartureTime, int planeNumberOfPassengers, int planeFlightTime, String planeStatus, String planeModel) {
        this.planeCallSign = planeCallSign;
        this.planeFlightStatus = planeFlightStatus;
        this.planeAltitude = planeAltitude;
        this.planeSpeed = planeSpeed;
        this.planeFlightNumber = planeFlightNumber;
        this.planeIATATypeCode = planeIATATypeCode;
        this.planeRegistration = planeRegistration;
        this.planeAirline = planeAirline;
        this.planeOrigin = planeOrigin;
        this.planeDestination = planeDestination;
        this.planeArrivalTime = planeArrivalTime;
        this.planeDepartureTime = planeDepartureTime;
        this.planeNumberOfPassengers = planeNumberOfPassengers;
        this.planeFlightTime = planeFlightTime;
        this.planeStatus = planeStatus;
        this.planeModel = planeModel;
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

    /**
     * Setter
     */

    public void setPlaneModel(String p)
    {
        planeModel = p;
    }
}
