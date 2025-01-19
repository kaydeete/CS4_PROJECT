import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class h2p implements MouseListener{
    JFrame frame;

    public h2p() {
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
        //asd
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
