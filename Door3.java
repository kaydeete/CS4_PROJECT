package Quarter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Door3 {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("LED Circuit Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create a panel for the content
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 204, 102)); // Light orange background

        // Title label
        JLabel titleLabel = new JLabel("<html><center>You are setting up a small home lighting system using LED lights.<br>"
                + "You have a 12V battery and you want to connect three LED bulbs in series, each with a resistance of 20 ohms.<br>"
                + "You need to calculate the total resistance and current through the circuit to make sure the battery can power the lights safely.</center></html>");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        // Create labels and text fields
        String[] questions = {
            "1. What is the total resistance in the circuit?",
            "2. What is the current flowing through the circuit?",
            "3. Let us say you want to add one more LED with the same resistance to the setup.\nHow will this change the total resistance and current in the circuit?",
            "4. If the maximum current the battery can provide safely is 0.3 A, can you add this extra LED bulb without exceeding the battery's safe current limit?"
        };

        for (String q : questions) {
            JLabel questionLabel = new JLabel("<html>" + q + "</html>");
            JTextField answerField = new JTextField();
            answerField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30)); // Stretch horizontally
            panel.add(questionLabel);
            panel.add(answerField);
            panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        }

        // Add the panel to the frame
        frame.add(new JScrollPane(panel), BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
