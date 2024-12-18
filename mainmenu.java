import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainmenu implements MouseListener{

    JFrame frame;
    JLabel start;
    JLabel settings; 
    JLabel quit;
    //ImageIcon gameBG;
    ImageIcon starticon;
    ImageIcon settingsicon;
    ImageIcon quiticon;
    ImageIcon img;
    PlaySound click;
    
    public mainmenu() {
        frame = new JFrame();
        click = new PlaySound();
        
        starticon=new ImageIcon("Images/start.png");    //259x80 px
        img=new ImageIcon(starticon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        start=new JLabel(img);
        
        settingsicon=new ImageIcon("Images/settings.png");    //259x80 px
        img=new ImageIcon(settingsicon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        settings=new JLabel(img);

        quiticon=new ImageIcon("Images/quit.png");    //259x80 px
        img=new ImageIcon(quiticon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        quit=new JLabel(img);
        
        
        /*gameBG*/
        JPanel backgroundPanel = new JPanel() {
            private final Image gameBG = new ImageIcon("Images/mainmenuBG.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(gameBG, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel);
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (10,10)));
        
        frame.add(start, new Rectangle (1,1,8,2));
        frame.add(settings, new Rectangle (1,4,8,2));
        frame.add(quit, new Rectangle (1,7,8,2));
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        addListeners();
    }
    
    public void addListeners() {
        start.addMouseListener(this);
        settings.addMouseListener(this);
        quit.addMouseListener(this);
    }
    
    public static void main(String[] args) {
        mainmenu screen = new mainmenu();
        screen.setFrame();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        click.playEffect("Audio/click.wav");
        if(e.getSource()==start){
            start ng=new start();
            Point p=frame.getLocation();
            ng.setFrame();
            ng.frame.setLocation(p);
            frame.dispose();
        }
        else if(e.getSource()==settings){
            settings ng=new settings();
            Point p=frame.getLocation();
            ng.setFrame();
            ng.frame.setLocation(p);
            frame.dispose();
        }
        else if(e.getSource()==quit){
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