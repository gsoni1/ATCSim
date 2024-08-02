package atc.atcsim;
import java.util.*;

/**
 * The airlinemanager class is a class that airlines can use to track and manage their fleet globally, such as see where
 * each of their planes are, how many models they have, how many routes are being served, etc.
 *
 * @author Gautam Soni
 * @version 7/10/2024
 */
public class AirlineManager {
    // fields
    private Graph<Object> airlineFleet;
    private HashMap<String, Integer> fleetCount;

    public AirlineManager() {
        airlineFleet = new Graph<Object>();
        fleetCount = new HashMap<String, Integer>();
        fleetCount.put("All Aircraft", 0);
        fleetCount.put("Boeing", 0);
        fleetCount.put("Airbus", 0);
        fleetCount.put("B737", 0);
        fleetCount.put("B747", 0);
        fleetCount.put("B757", 0);
        fleetCount.put("B767", 0);
        fleetCount.put("B777", 0);
        fleetCount.put("B787", 0);
        fleetCount.put("A220", 0);
        fleetCount.put("A300", 0);
        fleetCount.put("A310", 0);
        fleetCount.put("A318", 0);
        fleetCount.put("A319", 0);
        fleetCount.put("A319neo", 0);
        fleetCount.put("A320", 0);
        fleetCount.put("A320neo", 0);
        fleetCount.put("A321", 0);
        fleetCount.put("A321neo", 0);
        fleetCount.put("A330", 0);
        fleetCount.put("A340", 0);
        fleetCount.put("A350", 0);
        fleetCount.put("A380", 0);

        // Add manufacturers
        airlineFleet.addVertex("Boeing");
        airlineFleet.addVertex("Airbus");

        // Add Boeing models
        airlineFleet.addVertex("B737");
        airlineFleet.addVertex("B747");
        airlineFleet.addVertex("B757");
        airlineFleet.addVertex("B767");
        airlineFleet.addVertex("B777");
        airlineFleet.addVertex("B787");

        // Connect Boeing models vertices to Boeing vertex
        airlineFleet.addEdge("Boeing", "B737", true);
        airlineFleet.addEdge("Boeing", "B747", true);
        airlineFleet.addEdge("Boeing", "B757", true);
        airlineFleet.addEdge("Boeing", "B767", true);
        airlineFleet.addEdge("Boeing", "B777", true);
        airlineFleet.addEdge("Boeing", "B787", true);

        // Add Airbus models
        airlineFleet.addVertex("A220");
        airlineFleet.addVertex("A300");
        airlineFleet.addVertex("A310");
        airlineFleet.addVertex("A318");
        airlineFleet.addVertex("A319");
        airlineFleet.addVertex("A319neo");
        airlineFleet.addVertex("A320");
        airlineFleet.addVertex("A320neo");
        airlineFleet.addVertex("A321");
        airlineFleet.addVertex("A321neo");
        airlineFleet.addVertex("A330");
        airlineFleet.addVertex("A340");
        airlineFleet.addVertex("A350");
        airlineFleet.addVertex("A380");

        // Connect Airbus models vertices to Airbus vertex
        airlineFleet.addEdge("Airbus", "A220", true);
        airlineFleet.addEdge("Airbus", "A300", true);
        airlineFleet.addEdge("Airbus", "A310", true);
        airlineFleet.addEdge("Airbus", "A318", true);
        airlineFleet.addEdge("Airbus", "A319", true);
        airlineFleet.addEdge("Airbus", "A319neo", true);
        airlineFleet.addEdge("Airbus", "A320", true);
        airlineFleet.addEdge("Airbus", "A320neo", true);
        airlineFleet.addEdge("Airbus", "A321", true);
        airlineFleet.addEdge("Airbus", "A321neo", true);
        airlineFleet.addEdge("Airbus", "A330", true);
        airlineFleet.addEdge("Airbus", "A340", true);
        airlineFleet.addEdge("Airbus", "A350", true);
        airlineFleet.addEdge("Airbus", "A380", true);
    }

    public boolean addPlaneToFleet(Plane p) {
        if (!doesPlaneExistInFleet(p)) {
//            airlineFleet.addVertex(p.getPlaneRegistration());
            airlineFleet.addVertex(p);
            airlineFleet.addEdge(p.getPlaneModel(), p, true);
            fleetCount.replace(p.getPlaneModel(), getNumOfPlaneModel(p.getPlaneModel()) + 1); // increment the count for the plane model
            fleetCount.replace("All Aircraft", getNumOfAllPlanes() + 1); // increment the count for all planes
            fleetCount.replace(p.getPlaneManufacturer(), getNumOfPlaneManufacturer(p.getPlaneManufacturer()) + 1); // increment the count for the plane manufacturer
            return true;
        }
        return false;
    }

    public boolean doesPlaneExistInFleet(Plane p) {
        return airlineFleet.hasVertex(p);
    }

//    public Object getPlaneInFleet(Plane p) {
//        return airlineFleet.getVertex(p);
//    }

    public boolean removePlaneFromFleet(Plane p) {
        if (airlineFleet.hasVertex(p)) {
            airlineFleet.removeVertex(p);
            fleetCount.replace(p.getPlaneModel(), getNumOfPlaneModel(p.getPlaneModel()) - 1); // decrement the count for the plane model
            fleetCount.replace("All Aircraft", getNumOfAllPlanes() - 1); // decrement the count for all planes
            fleetCount.replace(p.getPlaneManufacturer(), getNumOfPlaneManufacturer(p.getPlaneManufacturer()) - 1); // decrement the count for the plane manufacturer
            return true;
        }
        return false;
    }

    public int getNumOfAllPlanes() {
        return fleetCount.get("All Aircraft");
    }

    public int getNumOfPlaneModel(String planeModel) {
        return fleetCount.get(planeModel);
    }

    public int getNumOfPlaneManufacturer(String planeManufacturer) {
        return fleetCount.get(planeManufacturer);
    }

    public boolean clearFleet() {
        for
        fleetCount.replace(p.getPlaneModel(), 0);
        fleetCount.replace("All Aircraft", 0);
        fleetCount.replace(p.getPlaneManufacturer(), 0);
        return airlineFleet.clearGraph();
    }

    public boolean isFleetEmpty() {
        return getNumOfAllPlanes() == 0;
    }
}

/**
 * The Graph class contains the implementation for the Graph data structure and its methods to be used in the Airline
 * Manager class
 * @param <T> type of Graph data structure
 */
class Graph<T> {

    // We use Hashmap to store the edges in the graph
    private Map<T, List<T> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source, T destination,
                        boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    public boolean removeVertex(T s) {
        if (hasVertex(s)) {
            map.remove(s);
            return true;
        }
        return false;
    }

    public Object getVertex(T s) {
        return map.get(s);
    }

//    // This function gives the count of vertices
//    public int getVertexCount()
//    {
//        return map.keySet().size();
//    }

    public boolean clearGraph() {
        if (!map.isEmpty()) {
            map.clear();
            return true;
        }
        return false;
    }

    public boolean isGraphEmpty() {
        if (map.isEmpty()) {
            return true;
        }
        return false;
    }

//    // This function gives the count of edges
//    public void getEdgesCount(boolean bidirection)
//    {
//        int count = 0;
//        for (T v : map.keySet()) {
//            count += map.get(v).size();
//        }
//        if (bidirection == true) {
//            count = count / 2;
//        }
//        System.out.println("The graph has " + count
//                + " edges.");
//    }

    // This function gives whether
    // a vertex is present or not.
    public boolean hasVertex(T s)
    {
        return map.containsKey(s);
    }

//    // This function gives whether an edge is present or
//    // not.
//    public void hasEdge(T s, T d)
//    {
//        if (map.get(s).contains(d)) {
//            System.out.println(
//                    "The graph has an edge between " + s
//                            + " and " + d + ".");
//        }
//        else {
//            System.out.println(
//                    "The graph has no edge between " + s
//                            + " and " + d + ".");
//        }
//    }

//    public void neighbours(T s)
//    {
//        if(!map.containsKey(s))
//            return ;
//        System.out.println("The neighbours of "+s+" are");
//        for(T w:map.get(s))
//            System.out.print(w+",");
//    }

//    // Prints the adjancency list of each vertex.
//    @Override public String toString()
//    {
//        StringBuilder builder = new StringBuilder();
//
//        for (T v : map.keySet()) {
//            builder.append(v.toString() + ": ");
//            for (T w : map.get(v)) {
//                builder.append(w.toString() + " ");
//            }
//            builder.append("\n");
//        }
//
//        return (builder.toString());
//    }
}