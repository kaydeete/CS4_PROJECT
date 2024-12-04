import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainmenu implements MouseListener{

    JFrame frame;
    JLabel start;
    JLabel settings; 
    JLabel quit;
    ImageIcon gameBG;
    ImageIcon starticon;
    ImageIcon settingsicon;
    ImageIcon quiticon;
    ImageIcon img;
    
    public mainmenu() {
        frame = new JFrame();
        
        starticon=new ImageIcon("Images/start.png");    //259x80 px
        img=new ImageIcon(starticon.getImage().getScaledInstance(207, 80, Image.SCALE_DEFAULT));
        start=new JLabel(img);
        
        settingsicon=new ImageIcon("Images/settings.png");    //259x80 px
        img=new ImageIcon(settingsicon.getImage().getScaledInstance(207, 80, Image.SCALE_DEFAULT));
        settings=new JLabel(img);

        quiticon=new ImageIcon("Images/quit.png");    //259x80 px
        img=new ImageIcon(quiticon.getImage().getScaledInstance(207, 80, Image.SCALE_DEFAULT));
        quit=new JLabel(img);
        
        gameBG = new ImageIcon("Images/mainmenuBG.png");
        frame.setContentPane(new JLabel(gameBG));
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (10,10)));
        
        frame.add(start, new Rectangle (1,1,8,5));
        frame.add(settings, new Rectangle (1,4,8,2));
        frame.add(quit, new Rectangle (1,7,8,2));
        
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        addListeners();
    }
    
    public void addListeners() {
        start.addMouseListener(this);
    }
    
    public static void main(String[] args) {
        mainmenu screen = new mainmenu();
        screen.setFrame();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==start){
            start ng=new start();
            Point p=frame.getLocation();
            ng.setFrame();
            ng.frame.setLocation(p);
            frame.dispose();
        }
        else if(e.getSource()==settings){
            /*start ng=new start();
            Point p=frame.getLocation();
            ng.setFrame();
            ng.frame.setLocation(p);
            frame.dispose();*/
        }
        else if(e.getSource()==quit){
            /*start ng=new start();
            Point p=frame.getLocation();
            ng.setFrame();
            ng.frame.setLocation(p);
            frame.dispose();*/
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