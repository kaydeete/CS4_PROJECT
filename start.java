import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class start implements MouseListener{
    JFrame frame;
    
    JLabel nxtbtn;
    JLabel prevbtn;
    JLabel chatBox;
    JLabel amper;
    
    ImageIcon gameBG;
    ImageIcon img;
    ImageIcon imgicon;
    String chat[];
    
    public start() {
        frame = new JFrame();
        gameBG = new ImageIcon("Images/cutscene1.png");
        frame.setContentPane(new JLabel(gameBG));
        
        chat = new String[] {
            "Amper heard an unusual sound in his room...",
            "The breadboard was quivering. he took a step closer.",
            "Suddenly, the breadboard sucked him in!!"
        };
        
        imgicon = new ImageIcon("Images/nxtbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(66, 30, Image.SCALE_DEFAULT));
        nxtbtn = new JLabel(img);
        
        imgicon = new ImageIcon("Images/prevbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(66, 30, Image.SCALE_DEFAULT));
        prevbtn = new JLabel(img);
        
        imgicon = new ImageIcon("Images/amper.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(160, 320, Image.SCALE_DEFAULT));
    }
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (10,10)));
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        start screen = new start();
        screen.setFrame();
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
    public void mouseExited(MouseEvent e) {}
}