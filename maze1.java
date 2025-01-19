import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class maze1 implements MouseListener{
    JFrame frame;
    
    JLabel nxtbtn;
    JLabel prevbtn;

    JTextPane chatfield;
    JLabel chatbox;
    ImageIcon chatimg;

    JLabel whirl;
    JLabel breadboard;
    JLabel amper;

    ImageIcon gameBG;
    ImageIcon img;
    ImageIcon imgicon;
    String chat[];

    MyStyle ms;
    PlaySound click;

    public maze1() {
        imgicon = new ImageIcon("Images/nxtbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        nxtbtn = new JLabel(img);

        imgicon = new ImageIcon("Images/prevbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        prevbtn = new JLabel(img);

        imgicon = new ImageIcon("Images/amper.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(740, 450, Image.SCALE_DEFAULT));
        amper = new JLabel(img);
        
        chatimg = new ImageIcon("Images/chatimg.png");
        chatbox = new JLabel(chatimg);
        chatfield = new JTextPane();
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(25, 10)));
        frame.add(prevbtn, new Rectangle(0, 9, 3, 1));
        frame.add(nxtbtn, new Rectangle(22, 9, 3, 1));

        frame.add(chatbox, new Rectangle(1, 9, 26, 10));
        frame.add(chatfield, new Rectangle(0, 9, 26, 2));
        frame.add(amper, new Rectangle(5, 4, 3, 5));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        chatfield.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //write
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
