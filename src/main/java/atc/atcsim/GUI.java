package atc.atcsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame = new JFrame();
    private JLabel label = new JLabel("Plane selected: None           ");
    private JList<Plane> list1 = new JList<>();
    JButton button = new JButton("Select Plane");
    JButton button2 = new JButton("Add to Takeoff Queue");
    JButton button3 = new JButton("Remove from Takeoff Queue");
    JCheckBox checkBox1 = new JCheckBox("Runway 24L");

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

        // Creating a panel for the button and label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button);
        buttonPanel.add(label);
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new FlowLayout());
        buttonPanel2.add(button2);
        buttonPanel2.add(button3);

        // checkboxes

        buttonPanel2.add(checkBox1);

        // Adding the panels to the frame
        frame.setLayout(new BorderLayout());
        frame.add(listPanel, BorderLayout.NORTH); // List at the center
        frame.add(buttonPanel, BorderLayout.SOUTH); // Button and label at the bottom
        frame.add(buttonPanel2, BorderLayout.CENTER); // Button and label at the bottom

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ATC Controller");
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    // create one Frame
    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        label.setText("Plane selected: " + list1.getSelectedValue());

        if (e.getSource() == button) {
            label.setText("Plane selected: " + list1.getSelectedValue().getPlaneCallSign());
        }
        else if (checkBox1.isSelected() && e.getSource() == button2) {
            L24.addToLandingQueue(list1.getSelectedValue());
            label.setText("" + L24.getLandingQueue(list1.getSelectedValue()));
        }
        else if (checkBox1.isSelected() && e.getSource() == button3) {
//            L24.addToLandingQueue(list1.getSelectedValue());
            L24.removeFromLandingQueue(list1.getSelectedValue());
            label.setText("" + L24.getLandingQueue(list1.getSelectedValue()));
        }
    }
}