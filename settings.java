package Quarter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class settings implements MouseListener{
    
    JFrame frame;
    JLabel volumei;
    ImageIcon volumeicon;
    JLabel volumes; 
    ImageIcon volumeslider; 
    JLabel quit;
    JLabel howtoplay;
    //ImageIcon gameBG;
    ImageIcon quiticon;
    ImageIcon img;
    ImageIcon howtoplayicon;

    public settings(){
        frame = new JFrame();
        
        quiticon=new ImageIcon("Images/return.png");    //259x80 px
        img=new ImageIcon(quiticon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        quit=new JLabel(img);
        
        volumeicon=new ImageIcon("Images/soundvis.png");    //259x80 px
        img=new ImageIcon(volumeicon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        volumei=new JLabel(img);
        
        volumeslider=new ImageIcon("Images/soundslider.png");    //259x80 px
        img=new ImageIcon(volumeslider.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT));
        volumes=new JLabel(img);
        
        howtoplayicon=new ImageIcon("Images/howtoplay.png");    //259x80 px
        img=new ImageIcon(howtoplayicon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        howtoplay=new JLabel(img);
        
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
        
        frame.add(quit, new Rectangle (1,1,8,2));
        frame.add(volumei, new Rectangle (1,3,3,2));
        frame.add(volumes, new Rectangle (2,3,9,2));
        frame.add(howtoplay, new Rectangle(1,7,8,2));
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        addListeners();
    }
    
    public void addListeners() {
        quit.addMouseListener(this);
        howtoplay.addMouseListener(this);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()==quit){
            mainmenu ng=new mainmenu();
            Point p=frame.getLocation();
            ng.setFrame();
            ng.frame.setLocation(p);
            frame.dispose();
        }
        else if(e.getSource()==howtoplay) {
            h2p srn = new h2p();
            Point p=frame.getLocation();
            srn.setFrame();
            srn.frame.setLocation(p);
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