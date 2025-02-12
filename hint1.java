import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class hint1 implements MouseListener{
    JFrame frame;
    JLabel ret;
    ImageIcon img;
    ImageIcon returnicon;
    
    public hint1() {
        frame = new JFrame();
        
        returnicon=new ImageIcon("Images/return.png");    //259x80 px
        img=new ImageIcon(returnicon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        ret = new JLabel(img);
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(10, 10))); // Layout setup
        frame.setSize(900, 600); // Set the custom size of the frame
        
        frame.add(ret, new Rectangle(1,1,8,2));
        ret.addMouseListener(this);
        
        frame.setUndecorated(true); // Removes window borders
        frame.setVisible(true);
        frame.setResizable(false); // Prevent resizing
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == ret) {
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
