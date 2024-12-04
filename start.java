import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class start implements MouseListener{
    JFrame frame;
    ImageIcon gameBG;
    ImageIcon img;
    ImageIcon imgicon;
    
    public start() {
        frame = new JFrame();
    }
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (10,10)));
        frame.setSize(400,400);
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