import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class settings implements MouseListener{
    
    JFrame frame;
    
    public settings(){
        frame = new JFrame();
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (10,10)));
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
