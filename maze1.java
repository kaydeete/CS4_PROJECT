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

    public maze1() {
        frame = new JFrame();

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

        hinticon1a=new ImageIcon(new ImageIcon("Images/wire1a.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
        hint1a=new JLabel(img);
        hinticon1b=new ImageIcon(new ImageIcon("Images/wire1b.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
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
        System.out.println("Current Tile: " + currentTile + " | Value: " + map[currentTile]);
        int keyCode = e.getKeyCode();
        int prevTile = currentTile;

        if (keyCode == KeyEvent.VK_UP && currentTile >= 12 && (map[currentTile - 12] == 0 || map[currentTile - 12] == 2)) currentTile -= 12;
        else if (keyCode == KeyEvent.VK_DOWN && currentTile < map.length - 12 && (map[currentTile + 12] == 0 || map[currentTile + 12] == 2)) currentTile += 12;
        else if (keyCode == KeyEvent.VK_LEFT && currentTile % 12 > 0 && (map[currentTile - 1] == 0 || map[currentTile - 1] == 2)) currentTile -= 1;
        else if (keyCode == KeyEvent.VK_RIGHT && currentTile % 12 < 11 && (map[currentTile + 1] == 0 || map[currentTile + 1] == 2)) currentTile += 1;
        
        if (prevTile != currentTile) {
            if (map[currentTile]==2) new Door1();
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

    public static void main(String[] args) {
        maze1 maze = new maze1();
        maze.setFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < mapL.length; i++) {
            if (e.getSource() == mapL[i]) { // Check if the clicked label is one of the hint tiles
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

class Door1 implements MouseListener{
    JFrame frame;
    JLabel ans1, ans2, ans3;
    ImageIcon ans1icon, ans2icon, ans3icon, img;

    public Door1() {
        frame = new JFrame();
        frame.setSize(1000, 700);
        frame.setLayout(new GraphPaperLayout(new Dimension(20,20)));
        
        JPanel backgroundPanel = new JPanel() {
            ImageIcon icon = new ImageIcon("Images/door1.png");

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw and scale the image to fill the panel
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        frame.setContentPane(backgroundPanel); // Set it as the content pane
        
        ans1icon=new ImageIcon("Images/d1ans1.png");    //259x80 px
        img=new ImageIcon(ans1icon.getImage().getScaledInstance(207, 64, Image.SCALE_DEFAULT));
        ans1=new JLabel(img);
        ans2icon=new ImageIcon("Images/d1ans2.png");    //259x80 px
        img=new ImageIcon(ans2icon.getImage().getScaledInstance(207, 64, Image.SCALE_DEFAULT));
        ans2=new JLabel(img);
        ans3icon=new ImageIcon("Images/d1ans3.png");    //259x80 px
        img=new ImageIcon(ans3icon.getImage().getScaledInstance(207, 64, Image.SCALE_DEFAULT));
        ans3=new JLabel(img);
        
        frame.add(ans1, new Rectangle(5,8,5,2));
        //frame.add(ans2, new Rectangle(550,300,207,64));
        //frame.add(ans3, new Rectangle(350,400,207,64));
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());
        backgroundPanel.add(closeButton);
        closeButton.setFont(new Font("Arial", Font.BOLD, 16)); // Change font, style, size
        closeButton.setForeground(Color.YELLOW); // Text color
        closeButton.setBackground(Color.WHITE); // Button background color
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setOpaque(true);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class hint1a {
    JFrame frame;
    ImageIcon close;

    public hint1a() {
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        JButton closeButton = new JButton("Close");
        closeButton.setBackground(Color.BLACK);
        closeButton.setFont(new Font("Arial", Font.BOLD, 20));
        closeButton.addActionListener(e -> frame.dispose());
        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }   
}

class hint1b {
    JFrame frame;

    public hint1b() {
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());

        /*JLabel message = new JLabel("🎉 You've reached the door!", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 18));*/

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());

        //frame.add(message, BorderLayout.CENTER);
        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}