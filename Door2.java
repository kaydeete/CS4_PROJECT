package Quarter2;

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
    JLabel ans1, ans2, ans3, ans4, doorL;
    ImageIcon ans1icon, ans2icon, ans3icon, ans4icon, img;
    ImageIcon icon = new ImageIcon("Images/d2q1.png");
    PlaySound wrong;

    public Door2() {
        frame = new JFrame();
        frame.setLayout(new GraphPaperLayout(new Dimension(20,20)));
        doorL=new JLabel(icon);
        frame.setSize(1000,700);
        wrong = new PlaySound();
        
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        frame.setContentPane(backgroundPanel);
        
        ans1icon=new ImageIcon("Images/d2q1a1.png");
        img=new ImageIcon(ans1icon.getImage().getScaledInstance(259, 150, Image.SCALE_DEFAULT));
        ans1=new JLabel(img);
        ans2icon=new ImageIcon("Images/d2q1a2.png");
        img=new ImageIcon(ans2icon.getImage().getScaledInstance(259, 150, Image.SCALE_DEFAULT));
        ans2=new JLabel(img);
        ans3icon=new ImageIcon("Images/d2q1a3.png");
        img=new ImageIcon(ans3icon.getImage().getScaledInstance(259, 150, Image.SCALE_DEFAULT));
        ans3=new JLabel(img);
        ans4icon=new ImageIcon("Images/d2q1a4.png");
        img=new ImageIcon(ans4icon.getImage().getScaledInstance(259, 150, Image.SCALE_DEFAULT));
        ans4=new JLabel(img);
        
        backgroundPanel.setLayout(null);
        ans1.setBounds(370, 150, 259, 150);
        ans2.setBounds(370, 250, 259, 150);
        ans3.setBounds(370, 350, 259, 150);
        ans4.setBounds(370, 450, 259, 150);
        backgroundPanel.add(ans1);
        backgroundPanel.add(ans2);
        backgroundPanel.add(ans3);
        backgroundPanel.add(ans4);
        
        ans1.addMouseListener(this);
        ans2.addMouseListener(this);
        ans3.addMouseListener(this);
        ans4.addMouseListener(this);
        
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
        if (e.getSource()==ans4) {
            new q2();
            frame.dispose();
        } else if (e.getSource() == ans2 || e.getSource() == ans3 || e.getSource() == ans1) {
            wrong.playEffect("Audio/ticerror.wav");
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

class q2 implements MouseListener{
    JFrame frame;
    ImageIcon backgroundImage;
    JLabel ans1, ans2, ans3, ans4;
    ImageIcon ans1icon, ans2icon, ans3icon, ans4icon, img;
    PlaySound wrong;

    public q2() {
        frame = new JFrame();
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());
        backgroundImage = new ImageIcon("Images/d2q2.png");
        wrong = new PlaySound();
        
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        
        ans1icon=new ImageIcon("Images/d2q2a1.png");
        img=new ImageIcon(ans1icon.getImage().getScaledInstance(259, 100, Image.SCALE_DEFAULT));
        ans1=new JLabel(img);
        ans2icon=new ImageIcon("Images/d2q2a2.png");
        img=new ImageIcon(ans2icon.getImage().getScaledInstance(259, 100, Image.SCALE_DEFAULT));
        ans2=new JLabel(img);
        ans3icon=new ImageIcon("Images/d2q2a3.png");
        img=new ImageIcon(ans3icon.getImage().getScaledInstance(259, 100, Image.SCALE_DEFAULT));
        ans3=new JLabel(img);
        ans4icon=new ImageIcon("Images/d2q2a4.png");
        img=new ImageIcon(ans4icon.getImage().getScaledInstance(259, 100, Image.SCALE_DEFAULT));
        ans4=new JLabel(img);
        
        backgroundPanel.setLayout(null);
        ans1.setBounds(370, 200, 259, 100);
        ans2.setBounds(370, 300, 259, 100);
        ans3.setBounds(370, 400, 259, 100);
        ans4.setBounds(370, 500, 259, 100);
        backgroundPanel.add(ans1);
        backgroundPanel.add(ans2);
        backgroundPanel.add(ans3);
        backgroundPanel.add(ans4);
        
        ans1.addMouseListener(this);
        ans2.addMouseListener(this);
        ans3.addMouseListener(this);
        ans4.addMouseListener(this);
        
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }   

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==ans3) {
            new correctansdoor2();
            frame.dispose();
        } else if (e.getSource() == ans1 || e.getSource() == ans2 || e.getSource() == ans4) {
            wrong.playEffect("Audio/ticerror.wav");
            JOptionPane.showMessageDialog(frame, "Incorrect answer. Please try again.", "Wrong Answer", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        new Door2();
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


   

class correctansdoor2 {
    JFrame frame;
    ImageIcon backgroundImage;
    JButton nextButton;

    public correctansdoor2() {
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        backgroundImage = new ImageIcon("Images/d2correct.png");
        
        nextButton = new JButton("Proceed to the Next Maze");
        nextButton.setBackground(Color.WHITE);
        nextButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        nextButton.addActionListener(e -> {
            
            frame.dispose();
                SwingUtilities.invokeLater(() -> {
                maze3 maze = new maze3();
                maze.setFrame();
                });
        });
        
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        
        

        backgroundPanel.add(nextButton, BorderLayout.SOUTH);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }   
}