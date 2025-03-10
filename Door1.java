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


class Door1 implements MouseListener{
    JFrame frame;
    JLabel ans1, ans2, ans3, doorL;
    ImageIcon ans1icon, ans2icon, ans3icon, img;
    ImageIcon icon = new ImageIcon("Images/door1.png");

    public Door1() {
        frame = new JFrame();
        frame.setLayout(new GraphPaperLayout(new Dimension(20,20)));
        doorL=new JLabel(icon);
        frame.setSize(1000,700);
        
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        frame.setContentPane(backgroundPanel);
        
        ans1icon=new ImageIcon("Images/d1ans1.png");
        img=new ImageIcon(ans1icon.getImage().getScaledInstance(259, 90, Image.SCALE_DEFAULT));
        ans1=new JLabel(img);
        ans2icon=new ImageIcon("Images/d1ans2.png");
        img=new ImageIcon(ans2icon.getImage().getScaledInstance(259, 90, Image.SCALE_DEFAULT));
        ans2=new JLabel(img);
        ans3icon=new ImageIcon("Images/d1ans3.png");
        img=new ImageIcon(ans3icon.getImage().getScaledInstance(259, 90, Image.SCALE_DEFAULT));
        ans3=new JLabel(img);
        
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
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());
        backgroundPanel.add(closeButton);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        closeButton.setForeground(Color.YELLOW);
        closeButton.setBackground(Color.WHITE);
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setOpaque(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==ans1) {
            new correctans();
            frame.dispose();
        } else if (e.getSource() == ans2 || e.getSource() == ans3) {
            JOptionPane.showMessageDialog(frame, "Incorrect answer. Please try again.", "Wrong Answer", JOptionPane.ERROR_MESSAGE);
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
            maze2 maze = new maze2();
            maze.setFrame();
            frame.dispose();
        });

        backgroundPanel.add(nextButton, BorderLayout.SOUTH);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }   
}