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

    // sample objects
    private Plane AI101 = new Plane("Airbus", "AI101", "Mid air", "EK61",
                              "B77W", "A6- EQB", "Qantas",
                              "FRA", "DXB", 7.00, 14.00,
                              200, 14, "taking off", "B777");
    private Plane AI102 = new Plane("Boeing", "AI102", "Mid air", "EK61",
            "B77W", "A6- EQB", "Qantas",
            "FRA", "DXB", 7.00, 14.00,
            200, 14, "taking off", "B777");
    private Airspace londonHeathrowAir;
    private GroundSpace londonHeathrowGround;
    private Runway L24 = new Runway("twenty four left", londonHeathrowAir, londonHeathrowGround);
    private Terminal T4;



    public GUI() {
        // the clickable button
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        clearforTakeoffButton.addActionListener(this);

        // Creating a panel for the list
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());

        // Setting up the list with elements
        DefaultListModel<Plane> l1 = new DefaultListModel<>();
        l1.addElement(AI101);
        l1.addElement(AI102);
        JList<Plane> list = new JList<>(l1);
        listPanel.add(new JScrollPane(list), BorderLayout.CENTER); // Add the list with a scroll pane
        list1 = list;
        listPanel.add(label, BorderLayout.SOUTH);
        listPanel.add(button, BorderLayout.EAST);
        label.setFont(new Font("Arial", Font.ITALIC, 20));
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));

        // Creating a panel for the button and label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
//        buttonPanel.add(button);
//        buttonPanel.add(label);
        JPanel buttonPanel2 = new JPanel();
        JPanel emergencyButtonPanel = new JPanel();
        buttonPanel2.setLayout(new FlowLayout());
        emergencyButtonPanel.setLayout(new FlowLayout());
        buttonPanel2.add(clearforTakeoffButton);
        buttonPanel2.add(button2);
//        buttonPanel2.add(button3);
        emergencyButtonPanel.add(button3);
        buttonPanel2.add(takeoffQueueLabel);
        buttonPanel2.add(button4);
        buttonPanel2.add(button5);
        buttonPanel2.add(landingQueueLabel);

        // checkboxes
        buttonPanel2.add(checkBox1);

        // Adding the panels to the frame
        frame.setLayout(new BorderLayout());
        frame.add(listPanel, BorderLayout.NORTH); // List at the center
        frame.add(buttonPanel, BorderLayout.SOUTH); // Button and label at the bottom
        frame.add(buttonPanel2, BorderLayout.CENTER); // Button and label at the bottom
        frame.add(emergencyButtonPanel, BorderLayout.WEST);

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
                    list1.getSelectedValue().getPlaneManufacturer()+ ", " +
                    list1.getSelectedValue().getPlaneModel() + ", " +
                    list1.getSelectedValue().getPlaneRegistration() + ", " +
                    list1.getSelectedValue().getPlaneAirline() + ", " +
                    list1.getSelectedValue().getPlaneOrigin() + ", " +
                    list1.getSelectedValue().getPlaneDestination() + ", " +
                    list1.getSelectedValue().getPlaneArrivalTime() + ", " +
                    list1.getSelectedValue().getPlaneDepartureTime());
        }
        // add to takeoff queue button 2
        else if (checkBox1.isSelected() && e.getSource() == button2) {
            if (L24.addToTakeoffQueue(list1.getSelectedValue())) {
                takeoffQueueLabel.setText(takeoffQueueLabel.getText() + list1.getSelectedValue().getPlaneCallSign() + ", ");
                takeoffQueuelist.add(list1.getSelectedValue().getPlaneCallSign());
            }
            else {
            label.setText(list1.getSelectedValue().getPlaneCallSign() + " is already in the Takeoff Queue");
            }
        }
        // remove from takeoff queue button 3
        else if (checkBox1.isSelected() && e.getSource() == button3) {
            if (L24.removeFromTakeoffQueue(list1.getSelectedValue())) {
                takeoffQueuelist.remove(list1.getSelectedValue().getPlaneCallSign());
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
                takeoffQueuelist.remove(list1.getSelectedValue().getPlaneCallSign());
                takeoffQueueLabel.setText("Takeoff Queue: ");
                for (String s : takeoffQueuelist) {
                    takeoffQueueLabel.setText(takeoffQueueLabel.getText() + s);
                }
            }
            else {
                label.setText(list1.getSelectedValue().getPlaneCallSign() + " is not in the Takeoff Queue");
            }
        }
    }
}