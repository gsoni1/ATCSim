package atc.atcsim;


/**
 * Plane class, contains all the variables related to a specific plane. Provides getter and setter methods to modify and
 * access plane variables.
 *
 * @author Arihita Dirghangi
 * @version 7/10/2024
 */
public class Plane {
    private String planeManufacturer; // Boeing
    private String planeModel; // B777
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
     * @param planeManufacturer assigned (Eg. Boeing)
     * @param planeCallSign assigned (Eg. AI101)
     * @param planeFlightStatus assigned (Eg. delayed)
     * @param planeModel assigned (Eg. B747)
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
    public Plane(String planeManufacturer, String planeCallSign, String planeFlightStatus, String planeFlightNumber, String planeIATATypeCode, String planeRegistration, String planeAirline, String planeOrigin, String planeDestination, Double planeArrivalTime, Double planeDepartureTime, int planeNumberOfPassengers, int planeFlightTime, String planeStatus, String planeModel) {
        this.planeManufacturer = planeManufacturer;
        this.planeCallSign = planeCallSign;
        this.planeFlightStatus = planeFlightStatus;
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
     * Getter method for variable planeManufacturer
     * @return String name of the plane manufacturer called
     */
    public String getPlaneManufacturer() {
        return planeManufacturer;
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
    public String getPlaneIATATypeCode()
    {
        return planeIATATypeCode;
    }

    /**
     * Getter method for variable planeRegistration
     * @return the plane registration code as a string
     */
    public String getPlaneRegistration()
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
     * Setter method for variable planeModel
     * @param p is the string name to be set for the planeModel
     */
    public void setPlaneModel(String p)
    {
        planeModel = p;
    }

    /**
     * Setter method for variable planeManufacturer
     * @param manufacturer is the string name to be set for the planeManufacturer
     */
    public void setPlaneManufacturer(String manufacturer)
    {
        planeManufacturer = manufacturer;
    }

    /**
     * Setter method for variable planeStatus
     * @param p is the string description for the planeStatus
     */
    public void setPlaneStatus(String p) {
        planeStatus = p;
    }

    /**
     * Setter method for variable planeCallSign
     * @param p is the string description for the plane's call sign
     */
    public void setPlaneCallSign(String p)
    {
        planeCallSign = p;
    }

    /**
     * Setter method for variable planeFlightNumber
     * @param p is the string description for the plane's flight number
     */
    public void setPlaneFlightNumber(String p)
    {
        planeFlightNumber = p;
    }

    /**
     * Setter method for variable planeIATATypeCode
     * @param p is the string description for the plane's IATA Type Code
     */
    public void setPlaneIATATypeCode(String p)
    {
        planeIATATypeCode = p;
    }

    /**
     * Setter method for variable planeRegistration
     * @param p is the string description for the plane registration status
     */
    public void setPlaneRegistration(String p)
    {
        planeRegistration = p;
    }

    /**
     * Setter method for variable planeAirline
     * @param p is the string description for the plane airline's name
     */
    public void setPlaneAirline(String p)
    {
        planeAirline = p;
    }

    /**
     * Setter method for variable planeOrigin
     * @param p is the string description for the plane's origin
     */
    public void setPlaneOrigin(String p)
    {
        planeOrigin = p;
    }

    /**
     * Setter method for variable planeDestination
     * @param p is the string description for the plane's destination
     */
    public void setPlaneDestination(String p)
    {
        planeDestination = p;
    }

    /**
     * Setter method for variable planeArrivalTime
     * @param p is the double variable for the plane's arrival time
     */
    public void setPlaneArrivalTime(Double p)
    {
        planeArrivalTime = p;
    }

    /**
     * Setter method for variable planeDepartureTime
     * @param p is the double variable for the plane's departure time
     */
    public void setPlaneDepartureTime(Double p)
    {
        planeDepartureTime = p;
    }

    /**
     * Setter method for variable planeNumberOfPassengers
     * @param n is the int variable for the number of passengers on the plane
     */
    public void setPlaneNumberOfPassengers(int n)
    {
        planeNumberOfPassengers = n;
    }

    /**
     * Setter method for variable planeFlightTime
     * @param n is the int variable for the flight time
     */
    public void setPlaneFlightTime(int n)
    {
        planeFlightTime = n;
    }

    /**
     * Setter method for variable planeFlightStatus
     * @param p is the string variable for the flight status
     */
    public void setPlaneFlightStatus(String p)
    {
        planeFlightStatus = p;
    }
}
