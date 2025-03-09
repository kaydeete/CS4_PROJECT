import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Door2 implements MouseListener{
    JFrame frame;
    JLabel ans1, ans2, ans3, doorL;
    ImageIcon ans1icon, ans2icon, ans3icon, img;
    ImageIcon icon = new ImageIcon("Images/door1.png");

    public Door2() {
        frame = new JFrame();
        frame.setLayout(new GraphPaperLayout(new Dimension(20,20)));
        doorL=new JLabel(icon);
        frame.setSize(1000,700);
        
        JPanel backgroundPanel = new JPanel() {
            //ImageIcon icon = new ImageIcon("Images/door1.png");

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw and scale the image to fill the panel
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        frame.setContentPane(backgroundPanel); // Set it as the content pane
        
        ans1icon=new ImageIcon("Images/d1ans1.png");
        img=new ImageIcon(ans1icon.getImage().getScaledInstance(259, 90, Image.SCALE_DEFAULT));
        ans1=new JLabel(img);
        ans2icon=new ImageIcon("Images/d1ans2.png");
        img=new ImageIcon(ans2icon.getImage().getScaledInstance(259, 90, Image.SCALE_DEFAULT));
        ans2=new JLabel(img);
        ans3icon=new ImageIcon("Images/d1ans3.png");
        img=new ImageIcon(ans3icon.getImage().getScaledInstance(259, 90, Image.SCALE_DEFAULT));
        ans3=new JLabel(img);
        
        // Add answers to the panel
        backgroundPanel.setLayout(null);
        ans1.setBounds(370, 300, 259, 90);
        ans2.setBounds(370, 400, 259, 90);
        ans3.setBounds(370, 500, 259, 90);
        backgroundPanel.add(ans1);
        backgroundPanel.add(ans2);
        backgroundPanel.add(ans3);
        
        
        ans1.addMouseListener(this);
        ans2.addMouseListener(this);
        ans3.addMouseListener(this);
        /*frame.add(ans1, new Rectangle(5,8,5,2));
        frame.add(ans2, new Rectangle(5,10,5,2));
        frame.add(ans3, new Rectangle(5,12,5,2));
        frame.add(doorL, new Rectangle(0,0,20,20));*/
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());
        backgroundPanel.add(closeButton);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Change font, style, size
        closeButton.setForeground(Color.YELLOW); // Text color
        closeButton.setBackground(Color.WHITE); // Button background color
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setOpaque(true);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
        frame.setSize(1000, 700);
        
        // Center the window without making it fullscreen
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==ans1) {
            new correctans();
            frame.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

class correctans {
    JFrame frame;
    ImageIcon backgroundImage;
    JButton nextButton;

    public correctans() {
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        backgroundImage = new ImageIcon("Images/d1correct.png");
        
        // Create a panel with the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        
        nextButton = new JButton("Proceed to the Next Maze");
        nextButton.setBackground(Color.WHITE);
        nextButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        nextButton.addActionListener(e -> {
            frame.dispose();
            new maze2();
                });

        backgroundPanel.add(nextButton, BorderLayout.SOUTH);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }   
}