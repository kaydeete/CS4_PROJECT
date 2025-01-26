import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class maze1 implements MouseListener, KeyListener {
    JFrame frame;
    JLabel[] mapL;
    int[] map;
    ImageIcon img1; // Wall
    ImageIcon img2; // Door
    ImageIcon amper; // Player
    int currentTile;

    public maze1() {
        frame = new JFrame();

        // Initialize map data
        map = new int[]{
            1,0,3,0,1,1,1,1,1,1,1,1,
            1,0,0,0,0,0,0,0,0,0,1,1,
            1,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,0,0,0,0,1,1,1,0,1,
            1,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,1,1,1,1,1,0,0,0,1,
            1,0,0,1,0,0,0,0,0,0,0,1,
            1,1,1,1,1,1,1,1,1,1,2,1
        };
        currentTile = 2;

        // Load images
        try {
            img1 = new ImageIcon(new ImageIcon("Images/brickwall.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
            img2 = new ImageIcon(new ImageIcon("Images/door.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
            amper = new ImageIcon(new ImageIcon("Images/amper.png").getImage().getScaledInstance(100, 60, Image.SCALE_DEFAULT));
        } catch (Exception e) {
            System.out.println("Image loading failed! Using default colors instead.");
        }

        // Initialize JLabel array
        mapL = new JLabel[map.length];
        for (int i = 0; i < map.length; i++) {
            mapL[i] = new JLabel();
            mapL[i].setOpaque(true); // Allow background color to show
            if (map[i] == 1) {
                //mapL[i].setBackground(Color.BLACK); // Wall
                if (img1 != null) mapL[i].setIcon(img1);
            } else if (map[i] == 2) {
                //mapL[i].setBackground(Color.BLUE); // Door
                if (img2 != null) mapL[i].setIcon(img2);
            } else if (map[i] == 3) {
                //mapL[i].setBackground(Color.GREEN); // Player
                if (amper != null) {
                    mapL[i].setIcon(amper);
                    //mapL[i].setBackground(new Color(0, 0, 0, 0));
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
        int keyCode = e.getKeyCode();
        int prevTile = currentTile;

        if (keyCode == KeyEvent.VK_UP && currentTile >= 12 && map[currentTile - 12] == 0) {
            currentTile -= 12;
        } else if (keyCode == KeyEvent.VK_DOWN && currentTile < map.length - 12 && map[currentTile + 12] == 0) {
            currentTile += 12;
        } else if (keyCode == KeyEvent.VK_LEFT && currentTile % 12 > 0 && map[currentTile - 1] == 0) {
            currentTile -= 1;
        } else if (keyCode == KeyEvent.VK_RIGHT && currentTile % 12 < 11 && map[currentTile + 1] == 0) {
            currentTile += 1;
        }

        if (prevTile != currentTile) {
            map[prevTile] = 0;
            map[currentTile] = 3;
            mapL[prevTile].setBackground(Color.WHITE);
            //mapL[currentTile].setBackground(Color.GREEN);
            mapL[prevTile].setIcon(null);
            mapL[currentTile].setIcon(amper);
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        maze1 maze = new maze1();
        maze.setFrame();
    }
}