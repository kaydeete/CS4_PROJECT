import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class start_srn {
    
    JFrame frame;
    
    public start_srn() {
        frame = new JFrame();
    }
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (10,10)));
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        start_srn screen = new start_srn();
        screen.setFrame();
    }
}
