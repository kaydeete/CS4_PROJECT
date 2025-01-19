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
    int chatseq=0;
    ImageIcon chatimg;

    JLabel amper;

    ImageIcon gameBG;
    ImageIcon img;
    ImageIcon imgicon;
    String chat[];

    MyStyle ms;
    PlaySound click;

    public maze1() {
        frame = new JFrame();
        
        imgicon = new ImageIcon("Images/nxtbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        nxtbtn = new JLabel(img);

        imgicon = new ImageIcon("Images/prevbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        prevbtn = new JLabel(img);
        
        chatimg = new ImageIcon("Images/chatimg.png");
        chatbox = new JLabel(chatimg);
        chatfield = new JTextPane();
        
        chat = new String[]{
            "Inside the breadboard is a MAZE",
            "Go to the items and click to find the mystery!"
        };
        
        styleChatField(chat[0]);
        
        prevbtn.addMouseListener(this);
        nxtbtn.addMouseListener(this);
        
        JPanel backgroundPanel = new JPanel() {
            private final Image gameBG = new ImageIcon("Images/maze1scrap.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(gameBG, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel);
    }
    
    public void styleChatField(String text) {
        chatfield.setText(text);
        chatfield.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        chatfield.setForeground(Color.WHITE);
        chatfield.setEditable(false);
        StyledDocument doc = chatfield.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(25, 10)));
        frame.add(prevbtn, new Rectangle(0, 9, 3, 1));
        frame.add(nxtbtn, new Rectangle(22, 9, 3, 1));

        frame.add(chatbox, new Rectangle(1, 9, 26, 10));
        frame.add(chatfield, new Rectangle(0, 9, 26, 2));
        chatfield.setBackground(new Color(51, 44, 42));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        chatfield.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == prevbtn) {
            if (chatseq - 1 >= 0) {
                chatseq--;
                chatfield.setText(chat[chatseq]);
            }
            setElements();
        } else if (e.getSource() == nxtbtn) {
            if (chatseq + 1 < chat.length) {
                chatseq++;
                chatfield.setText(chat[chatseq]);
            }        
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

    private void setElements() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
