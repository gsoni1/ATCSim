package atc.atcsim;

//import com.formdev.flatlaf.FlatLightLaf;

//import com.formdev.flatlaf.FlatLightLaf;

//import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
//import java.util.logging.Logger;

public class GUI implements ActionListener {

    private JFrame frame = new JFrame();
    private JLabel label = new JLabel("Plane selected: None           ");
    private JList<Plane> list1 = new JList<>();
    private JButton button = new JButton("Select Plane");
    private JButton button2 = new JButton("Add to Takeoff Queue");
    private JButton button3 = new JButton("Remove from Takeoff Queue");
    private ArrayList<String> takeoffQueuelist = new ArrayList<>();
    private ArrayList<String> landingQueuelist = new ArrayList<>();
    private JLabel takeoffQueueLabel = new JLabel("Takeoff Queue: ");
    private JButton button4 = new JButton("Add to Landing Queue");
    private JButton button5 = new JButton("Remove from Landing Queue");
    private JCheckBox checkBox1 = new JCheckBox("Runway 24L");
    private JLabel landingQueueLabel = new JLabel("Landing Queue: ");
    private JButton clearforTakeoffButton = new JButton("Clear for Takeoff");
    private JButton clearforLandingButton = new JButton("Clear for Landing");
    private JLabel emergencyLabel = new JLabel("Emergency Actions:");
    private JLabel runwayLabel = new JLabel("Runway Actions:");
    private JButton closeRunwayButton = new JButton("Close Runway");
    private JButton openRunwayButton = new JButton("Open Runway");
    private JLabel landingQueueSizeLabel = new JLabel("Planes in Landing Queue: 0");
    private JLabel takeoffQueueSizeLabel = new JLabel("Planes in Takeoff Queue: 0");
    private JLabel runwayclearanceLabel = new JLabel("Runway 24 is Clear");
    private JLabel airspaceclearanceLabel = new JLabel("The Airspace is Open");
    private JButton openAirspaceButton = new JButton("Open Airspace");
    private JButton closeAirspaceButton = new JButton("Close Airspace");
    private JLabel groundspaceclearanceLabel = new JLabel("The Groundspace is Open");
    private JLabel groundspaceSizeLabel = new JLabel("Planes in Groundspace: 0");
    private JLabel airspaceSizeLabel = new JLabel("Planes in Airspace: 0");
    private JButton openGroundspaceButton = new JButton("Open Groundspace");
    private JButton closeGroundspaceButton = new JButton("Close Groundspace");
    private JButton clearAirspaceButton = new JButton("Clear Airspace");
    private JButton clearGroundspaceButton = new JButton("Clear Groundspace");
    private JLabel terminalLabel = new JLabel("Terminal Actions:");
    private JLabel airlineManagerLabel = new JLabel("Airline Manager Actions:");
    private JButton addGateButton = new JButton("Add Gate");
    private JButton removeGateButton = new JButton("Remove Gate");
    private JButton searchGateButton = new JButton("Search Gate");
    private JTextField tf1 = new JTextField("Search by Gate Name");
    private JTextField addGateNameField = new JTextField("Enter a New Gate Name");
    private JTextField removeGateNameField = new JTextField("Remove a Gate by Name");
    private JLabel searchByGateResultLabel = new JLabel("");
//    private JLabel AirlineManagerLabel = new JLabel("Airline Management Actions: ");
    private JButton addPlaneToFleetButton = new JButton("Add Selected Plane to Fleet");
    private JButton removePlaneFromFleetButton = new JButton("Remove Selected Plane From Fleet");
    private JLabel numOfAllPlanesLabel = new JLabel("Total Planes in Singapore Airlines' Fleet: 0, ");
    private JLabel numOfBoeingPlanesLabel = new JLabel("Boeing: 0, ");
    private JLabel numOfAirbusPlanesLabel = new JLabel("Airbus: 0");
    private JTextField modelSearchField = new JTextField("Enter a Plane Model to Search");
    private JButton searchModelButton = new JButton("Search Model in Fleet");
    private JLabel numOfModel = new JLabel("");

    // sample objects
    private Plane AI101 = new Plane("Airbus", "AI101", "On Time", "EK61",
                              "B77W", "A6- EQB", "Qantas",
                              "FRA", "DXB", 7.00, 14.00,
                              200, 14, "At Gate", "B777", "In Groundspace");

    private Plane AI102 = new Plane("Boeing", "AI102", "On Time", "EK61",
            "B77W", "A6- EQB", "Qantas",
            "FRA", "DXB", 7.00, 14.00,
            200, 14, "Cruising", "B777", "In Airspace");
    private Airspace londonHeathrowAir = new Airspace();
    private GroundSpace londonHeathrowGround = new GroundSpace();
    private Runway L24 = new Runway("twenty four left", londonHeathrowAir, londonHeathrowGround);
    private Terminal T4 = new Terminal();
    private AirlineManager singaporeAirlines = new AirlineManager();



    public GUI() {
        // the clickable button
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        clearforTakeoffButton.addActionListener(this);
        clearforLandingButton.addActionListener(this);
        openRunwayButton.addActionListener(this);
        closeRunwayButton.addActionListener(this);
        openAirspaceButton.addActionListener(this);
        closeAirspaceButton.addActionListener(this);
        openGroundspaceButton.addActionListener(this);
        closeGroundspaceButton.addActionListener(this);
        clearAirspaceButton.addActionListener(this);
        clearGroundspaceButton.addActionListener(this);
//        tf1.addActionListener(this);
        addGateButton.addActionListener(this);
        removeGateButton.addActionListener(this);
        searchGateButton.addActionListener(this);
        addPlaneToFleetButton.addActionListener(this);
        removePlaneFromFleetButton.addActionListener(this);
        searchModelButton.addActionListener(this);






        // Creating a panel for the list
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());

        // Setting up the list with elements
        DefaultListModel<Plane> l1 = new DefaultListModel<>();
        l1.addElement(AI101);
        l1.addElement(AI102);
        londonHeathrowGround.addToGroundSpace(AI101);
        londonHeathrowAir.addToAirspace(AI102);
        JList<Plane> list = new JList<>(l1);
        listPanel.add(new JScrollPane(list), BorderLayout.CENTER); // Add the list with a scroll pane
        list1 = list;
        listPanel.add(label, BorderLayout.SOUTH);
        listPanel.add(button, BorderLayout.EAST);
        label.setFont(new Font("Arial", Font.ITALIC, 20));
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));

        // Creating a panel for the button and label
        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new FlowLayout());
//        buttonPanel.add(button);
        buttonPanel.add(terminalLabel);
        terminalLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        buttonPanel.add(addGateNameField);
//        buttonPanel.add(addGatePlaneField);
        buttonPanel.add(addGateButton);
        buttonPanel.add(removeGateNameField);
        buttonPanel.add(removeGateButton);
        buttonPanel.add(tf1);
        buttonPanel.add(searchGateButton);
        tf1.setBounds(50,50,150,20);
        buttonPanel.add(searchByGateResultLabel);
        JPanel runwayButtonPanel = new JPanel();
        JPanel emergencyButtonPanel = new JPanel();
        JPanel airlinemanagerButtonPanel = new JPanel();
        airlinemanagerButtonPanel.add(airlineManagerLabel);
        airlineManagerLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        airlinemanagerButtonPanel.add(numOfAllPlanesLabel);
        airlinemanagerButtonPanel.add(numOfBoeingPlanesLabel);
        airlinemanagerButtonPanel.add(numOfAirbusPlanesLabel);
        airlinemanagerButtonPanel.add(addPlaneToFleetButton);
        airlinemanagerButtonPanel.add(removePlaneFromFleetButton);
        airlinemanagerButtonPanel.add(modelSearchField);
        airlinemanagerButtonPanel.add(searchModelButton);
        airlinemanagerButtonPanel.add(numOfModel);
//        runwayButtonPanel.setLayout(new FlowLayout());
//        emergencyButtonPanel.setLayout(new FlowLayout());
        runwayButtonPanel.setLayout(new GridLayout(20, 2, 10, 10)); // Equal space for buttons in a 4x2 grid
        buttonPanel.setLayout(new GridLayout(20, 2, 10, 10));
        emergencyButtonPanel.setLayout(new GridLayout(20, 2, 10, 10));
        airlinemanagerButtonPanel.setLayout(new FlowLayout());
        runwayButtonPanel.add(runwayLabel);
        runwayLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        runwayButtonPanel.add(clearforTakeoffButton);
        runwayButtonPanel.add(button2);
        //        button2.setFont(new Font("Arial", Font.BOLD, 16));
//        runwayButtonPanel.add(button3);
        emergencyButtonPanel.add(emergencyLabel);
        emergencyLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        emergencyButtonPanel.add(button3);
        emergencyButtonPanel.add(button5);
        emergencyButtonPanel.add(closeRunwayButton);
        emergencyButtonPanel.add(openRunwayButton);
        emergencyButtonPanel.add(airspaceSizeLabel);
        emergencyButtonPanel.add(airspaceclearanceLabel);
        emergencyButtonPanel.add(openAirspaceButton);
        emergencyButtonPanel.add(closeAirspaceButton);
        emergencyButtonPanel.add(groundspaceSizeLabel);
        emergencyButtonPanel.add(groundspaceclearanceLabel);
        emergencyButtonPanel.add(openGroundspaceButton);
        emergencyButtonPanel.add(closeGroundspaceButton);
        emergencyButtonPanel.add(clearAirspaceButton);
        emergencyButtonPanel.add(clearGroundspaceButton);

        runwayButtonPanel.add(takeoffQueueSizeLabel);
        runwayButtonPanel.add(takeoffQueueLabel);
        runwayButtonPanel.add(clearforLandingButton);
        runwayButtonPanel.add(button4);
        runwayButtonPanel.add(landingQueueSizeLabel);
        runwayButtonPanel.add(landingQueueLabel);



        // checkboxes
        runwayButtonPanel.add(checkBox1);
        runwayButtonPanel.add(runwayclearanceLabel);

        // Adding the panels to the frame
        frame.setLayout(new BorderLayout());
        frame.add(listPanel, BorderLayout.NORTH); // List at the center
        frame.add(buttonPanel, BorderLayout.EAST); // Button and label at the bottom
        frame.add(runwayButtonPanel, BorderLayout.CENTER); // Button and label at the bottom
        frame.add(emergencyButtonPanel, BorderLayout.WEST);
        frame.add(airlinemanagerButtonPanel, BorderLayout.SOUTH);

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ATC Controller");
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    // create one Frame
    public static void main(String[] args) {
//        FlatLightLaf.setup();
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            label.setText("Plane selected: " + list1.getSelectedValue().getPlaneCallSign() + ", " +
                    list1.getSelectedValue().getPlaneFlightNumber() + ", " +
                    list1.getSelectedValue().getPlaneSpaceLocation() + ", " +
                    list1.getSelectedValue().getPlaneManufacturer()+ ", " +
                    list1.getSelectedValue().getPlaneModel() + ", " +
                    list1.getSelectedValue().getPlaneIATATypeCode() + ", " +
                    list1.getSelectedValue().getPlaneRegistration() + ", " +
                    list1.getSelectedValue().getPlaneAirline() + ", Origin: " +
                    list1.getSelectedValue().getPlaneOrigin() + ", Destination: " +
                    list1.getSelectedValue().getPlaneDestination() + ", " +
                    list1.getSelectedValue().getPlaneFlightStatus() + ", " +
                    list1.getSelectedValue().getPlaneStatus()
            );
        }
        // add to takeoff queue button 2
        else if (checkBox1.isSelected() && e.getSource() == button2) {
            if (L24.addToTakeoffQueue(list1.getSelectedValue())) {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " added to the Takeoff Queue");
                takeoffQueueSizeLabel.setText("Planes in Takeoff Queue: " + L24.getTakeoffQueueSize());
                takeoffQueueLabel.setText(takeoffQueueLabel.getText() + list1.getSelectedValue().getPlaneCallSign() + ", ");
                takeoffQueuelist.add(list1.getSelectedValue().getPlaneCallSign());
            }
            else {
            label.setText(list1.getSelectedValue().getPlaneCallSign() + " is already in the Takeoff Queue");
            }
        }
        // remove from takeoff queue button 3
        else if (checkBox1.isSelected() && e.getSource() == button3) {
            label.setText(list1.getSelectedValue().getPlaneCallSign() + " removed from the Takeoff Queue");

            if (L24.removeFromTakeoffQueue(list1.getSelectedValue())) {
                takeoffQueuelist.remove(list1.getSelectedValue().getPlaneCallSign());
                takeoffQueueSizeLabel.setText("Planes in Takeoff Queue: " + L24.getTakeoffQueueSize());
                takeoffQueueLabel.setText("Takeoff Queue: ");
                for (String s : takeoffQueuelist) {
                    takeoffQueueLabel.setText(takeoffQueueLabel.getText() + s);
                }
            }
            else {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is not in the Takeoff Queue");
            }
        }
        // add to landing queue button 4
        else if (checkBox1.isSelected() && e.getSource() == button4) {
            if (L24.addToLandingQueue(list1.getSelectedValue())) {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " added to the Landing Queue");
                landingQueueSizeLabel.setText("Planes in Landing Queue: " + L24.getLandingQueueSize());
                landingQueueLabel.setText(landingQueueLabel.getText() + list1.getSelectedValue().getPlaneCallSign() + ", ");
                landingQueuelist.add(list1.getSelectedValue().getPlaneCallSign());
            }
            else {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is already in the Landing Queue");
            }
        }
        // remove from landing queue button 5
        else if (checkBox1.isSelected() && e.getSource() == button5) {
            if (L24.removeFromLandingQueue(list1.getSelectedValue())) {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " removed from the Landing Queue");
                landingQueueSizeLabel.setText("Planes in Landing Queue: " + L24.getLandingQueueSize());
                landingQueuelist.remove(list1.getSelectedValue().getPlaneCallSign());
                landingQueueLabel.setText("Landing Queue: ");
                for (String s : landingQueuelist) {
                    landingQueueLabel.setText(landingQueueLabel.getText() + s);
                }
            }
            else {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is not in the Landing Queue");
            }
        }
        // clear for takeoff button
        else if (checkBox1.isSelected() && e.getSource() == clearforTakeoffButton) {
            if (L24.clearForTakeoff(list1.getSelectedValue())) {
                runwayclearanceLabel.setText("Runway 24 is currently Not Clear");
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is Now Taking Off");
                takeoffQueuelist.remove(list1.getSelectedValue().getPlaneCallSign());
                takeoffQueueLabel.setText("Takeoff Queue: ");
                takeoffQueueSizeLabel.setText("Planes in Takeoff Queue: " + L24.getTakeoffQueueSize());
                for (String s : takeoffQueuelist) {
                    takeoffQueueLabel.setText(takeoffQueueLabel.getText() + s);
                }
                runwayclearanceLabel.setText("Runway 24 is currently Clear");
            }
            else {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is not in the Takeoff Queue");
            }
        }
        // clear for landing button
        else if (checkBox1.isSelected() && e.getSource() == clearforLandingButton) {
            if (L24.clearForLanding(list1.getSelectedValue())) {
                runwayclearanceLabel.setText("Runway 24 is currently Not Clear");
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is Now Landing");
                landingQueuelist.remove(list1.getSelectedValue().getPlaneCallSign());
                landingQueueLabel.setText("Landing Queue: ");
                landingQueueSizeLabel.setText("Planes in Landing Queue: " + L24.getLandingQueueSize());
                for (String s : landingQueuelist) {
                    landingQueueLabel.setText(landingQueueLabel.getText() + s);
                }
                runwayclearanceLabel.setText("Runway 24 is currently Clear");
            }
            else {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is not in the Landing Queue");
            }
        }
        // close runway button
        else if (checkBox1.isSelected() && e.getSource() == closeRunwayButton) {
            L24.closeRunway();
            label.setText("Runway 24 Left is Now Closed");
            runwayclearanceLabel.setText("Runway 24 is currently Not Clear");
        }
        // close runway button
        else if (checkBox1.isSelected() && e.getSource() == openRunwayButton) {
            L24.openRunway();
            label.setText("Runway 24 Left is Now Open");
            runwayclearanceLabel.setText("Runway 24 is currently Clear");
        }
        // close airspace button
        else if (e.getSource() == closeAirspaceButton) {
            londonHeathrowAir.closeAirspace();
            label.setText("London Heathrow Airspace is Now Closed");
            airspaceclearanceLabel.setText("Airspace is Closed");
        }
        // open airspace button
        else if (e.getSource() == openAirspaceButton) {
            londonHeathrowAir.openAirspace();
            label.setText("London Heathrow Airspace is Now Open");
            airspaceclearanceLabel.setText("Airspace is Open");
        }
        // close Groundspace button
        else if (e.getSource() == closeGroundspaceButton) {
            londonHeathrowGround.closeGroundSpace();
            label.setText("London Heathrow Groundspace is Now Closed");
            groundspaceclearanceLabel.setText("Groundspace is Closed");
        }
        // open Groundspace button
        else if (e.getSource() == openGroundspaceButton) {
            londonHeathrowGround.openGroundSpace();
            label.setText("London Heathrow Groundspace is Now Open");
            groundspaceclearanceLabel.setText("Groundspace is Open");
        }
        // clear Groundspace button
        else if (e.getSource() == clearGroundspaceButton) {
            londonHeathrowGround.clearGroundSpace();
            label.setText("London Heathrow Groundspace is Now Empty");
        }
        // clear Airspace button
        else if (e.getSource() == clearAirspaceButton) {
            londonHeathrowAir.clearAirspace();
            label.setText("London Heathrow Airspace is Now Empty");
        }
        // search gate button
        else if (e.getSource() == searchGateButton) {
            Plane ans = T4.getPlane(tf1.getText());
            searchByGateResultLabel.setText(ans.getPlaneCallSign() + " is at Gate " + tf1.getText());
        }
        // add gate field and button
        else if (e.getSource() == addGateButton) {
            Plane p = list1.getSelectedValue();
            String gateName = addGateNameField.getText();
            if (T4.addGate(gateName, p)) {
                label.setText(p.getPlaneCallSign() + " added to Gate " + gateName);
            }
        }
        // remove gate field and button
        else if (e.getSource() == removeGateButton) {
            String gateName = removeGateNameField.getText();
            Plane p = T4.getPlane(gateName);
            if (T4.removeGate(gateName)) {
                label.setText(p.getPlaneCallSign() + " removed from Gate " + gateName);
            }
        }
        // add plane to fleet button
        else if (e.getSource() == addPlaneToFleetButton) {
            if (singaporeAirlines.addPlaneToFleet(list1.getSelectedValue())) {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " added to Fleet ");
                numOfAirbusPlanesLabel.setText("Airbus: " + singaporeAirlines.getNumOfPlaneManufacturer("Airbus"));
                numOfBoeingPlanesLabel.setText("Boeing: " + singaporeAirlines.getNumOfPlaneManufacturer("Boeing") + ", ");
                numOfAllPlanesLabel.setText("Total Planes in Singapore Airlines' Fleet: " + singaporeAirlines.getNumOfAllPlanes() + ", ");
            }
        }
        // remove plane from fleet button
        else if (e.getSource() == removePlaneFromFleetButton) {
            if (singaporeAirlines.removePlaneFromFleet(list1.getSelectedValue())) {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " removed from Fleet ");
                numOfAirbusPlanesLabel.setText("Airbus: " + singaporeAirlines.getNumOfPlaneManufacturer("Airbus"));
                numOfBoeingPlanesLabel.setText("Boeing: " + singaporeAirlines.getNumOfPlaneManufacturer("Boeing") + ", ");
                numOfAllPlanesLabel.setText("Total Planes in Singapore Airlines' Fleet: " + singaporeAirlines.getNumOfAllPlanes() + ", ");
            }
        }
        // search gate button
        else if (e.getSource() == searchModelButton) {
            String model = modelSearchField.getText();
            numOfModel.setText("Number of " + model + " in Fleet :" + singaporeAirlines.getNumOfPlaneModel(model));
        }
    }
}