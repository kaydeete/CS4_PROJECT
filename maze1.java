package Quarter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class maze1 implements KeyListener, MouseListener {
    JFrame frame;
    JLabel[] mapL;
    int[] map;
    ImageIcon img1; // Wall
    ImageIcon img2; // Door
    ImageIcon amper; // Player
    ImageIcon img;
    ImageIcon hinticon1a;
    ImageIcon hinticon1b;
    JLabel hint1a;
    JLabel hint1b;
    int currentTile;
    PlaySound click;

    public maze1() {
        frame = new JFrame();
        click = new PlaySound();

        // Initialize map data
        map = new int[]{
            1,0,3,0,1,1,1,1,1,1,1,1,
            1,0,0,0,0,0,0,0,0,0,1,1,
            1,0,0,0,0,0,0,0,5,0,0,1,
            1,0,0,0,0,0,0,1,1,1,0,1,
            1,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,1,1,1,1,1,0,0,0,1,
            1,0,4,1,0,0,0,0,0,0,0,1,
            1,1,1,1,1,1,1,1,1,1,2,1
        };
        currentTile = 2;

        img1 = new ImageIcon(new ImageIcon("Images/brickwall.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
        img2 = new ImageIcon(new ImageIcon("Images/door.png").getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
        amper = new ImageIcon(new ImageIcon("Images/amper.png").getImage().getScaledInstance(100, 60, Image.SCALE_DEFAULT));

        hinticon1a=new ImageIcon(new ImageIcon("Images/wirea.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
        hint1a=new JLabel(img);
        hinticon1b=new ImageIcon(new ImageIcon("Images/wireb.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
        hint1b=new JLabel(img);
        
        // Initialize JLabel array
        mapL = new JLabel[map.length];
        for (int i = 0; i < map.length; i++) {
            mapL[i] = new JLabel();
            //mapL[i].setOpaque(true); // Allow background color to show
            if (map[i] == 1) {
                if (img1 != null) mapL[i].setIcon(img1);
            } else if (map[i] == 2) {
                if (img2 != null) mapL[i].setIcon(img2);
            } else if (map[i] == 3) {
                if (amper != null) {
                    mapL[i].setIcon(amper);
                }
            } else if (map[i] == 4) {
                if (hinticon1a != null) {
                    mapL[i].setIcon(hinticon1a);
                    mapL[i].addMouseListener(this); // Add mouse listener to hint icon
                }
            } else if (map[i] == 5) {
                if (hinticon1b != null) {
                    mapL[i].setIcon(hinticon1b);
                    mapL[i].addMouseListener(this); // Add mouse listener to hint icon
                }
            } else {
                mapL[i].setBackground(Color.WHITE); // Empty space
            }
        }
    }

    public void setFrame() {
        frame.setLayout(new BorderLayout());

        // Map Panel
        JPanel mapPanel = new JPanel(new GridLayout(8, 12, 2, 2)); // 8 rows, 12 columns
        for (JLabel label : mapL) {
            mapPanel.add(label);
        }
        
        frame.add(mapPanel, BorderLayout.CENTER);
        System.out.println("Frame and map initialized successfully!");
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.addKeyListener(this);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        click.playEffect("Audio/steps.wav");
        System.out.println("Current Tile: " + currentTile + " | Value: " + map[currentTile]);
        int keyCode = e.getKeyCode();
        int prevTile = currentTile;

        if (keyCode == KeyEvent.VK_UP && currentTile >= 12 && (map[currentTile - 12] == 0 || map[currentTile - 12] == 2)) currentTile -= 12;
        else if (keyCode == KeyEvent.VK_DOWN && currentTile < map.length - 12 && (map[currentTile + 12] == 0 || map[currentTile + 12] == 2)) currentTile += 12;
        else if (keyCode == KeyEvent.VK_LEFT && currentTile % 12 > 0 && (map[currentTile - 1] == 0 || map[currentTile - 1] == 2)) currentTile -= 1;
        else if (keyCode == KeyEvent.VK_RIGHT && currentTile % 12 < 11 && (map[currentTile + 1] == 0 || map[currentTile + 1] == 2)) currentTile += 1;
        
        if (prevTile != currentTile) {
            if (map[currentTile] == 2) {
                frame.dispose();
                SwingUtilities.invokeLater(() -> {
                    new Door1();
                });
                return; // ADD THIS to stop further movement!
            }
            mapL[prevTile].setBackground(Color.WHITE);
            //mapL[currentTile].setBackground(Color.GREEN);
            mapL[prevTile].setIcon(null);
            mapL[currentTile].setIcon(amper);
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        maze1 maze = new maze1();
        maze.setFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < mapL.length; i++) {
            if (e.getSource() == mapL[i]) { // Check if the clicked label is one of the hint tiles
                click.playEffect("Audio/ticclick.wav");
                if (map[i] == 4) new hint1a();
                else if (map[i] == 5) new hint1b();
            }
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

class hint1a {
    JFrame frame;
    ImageIcon close;

    public hint1a() {
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());

        ImageIcon originalIcon = new ImageIcon("Images/hint1.png");
        Image originalImage = originalIcon.getImage();
        
        // Scale image to fit within the frame size
        int newWidth = frame.getWidth();
        int newHeight = frame.getHeight() - 80; // Adjust for button space
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.add(imageLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.setBackground(Color.WHITE);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        closeButton.addActionListener(e -> frame.dispose());

        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
        
}

class hint1b {
    JFrame frame;
    ImageIcon close;

    public hint1b() {
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        
                ImageIcon originalIcon = new ImageIcon("Images/hint2.png");
        Image originalImage = originalIcon.getImage();
        
        // Scale image to fit within the frame size
        int newWidth = frame.getWidth();
        int newHeight = frame.getHeight() - 80; // Adjust for button space
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.add(imageLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.setBackground(Color.WHITE);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        closeButton.addActionListener(e -> frame.dispose());

        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}