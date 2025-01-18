import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class settings implements MouseListener{
    
    JFrame frame;
    JLabel start;
    JLabel settings; 
    JLabel quit;
    //ImageIcon gameBG;
    ImageIcon quiticon;
    ImageIcon img;

    public settings(){
        frame = new JFrame();
        
        quiticon=new ImageIcon("Images/quit.png");    //259x80 px
        img=new ImageIcon(quiticon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        quit=new JLabel(img);
        
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
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        addListeners();
    }
    
    public void addListeners() {
        quit.addMouseListener(this);
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
