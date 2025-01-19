import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class start implements MouseListener {

    JFrame frame;

    JLabel nxtbtn;
    JLabel prevbtn;

    JTextPane chatfield;
    JLabel chatbox;
    int chatseq = 0;
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

    public start() {
        frame = new JFrame();

        JPanel backgroundPanel = new JPanel() {
            private final Image gameBG = new ImageIcon("Images/cutscene1.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(gameBG, 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel);

        chat = new String[]{
            "Amper heard an unusual sound in his room...",
            "The breadboard was quivering so he took a step closer.",
            "Suddenly, the breadboard sucked him in!!"
        };

        imgicon = new ImageIcon("Images/nxtbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        nxtbtn = new JLabel(img);

        imgicon = new ImageIcon("Images/prevbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        prevbtn = new JLabel(img);

        imgicon = new ImageIcon("Images/amper.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(740, 450, Image.SCALE_DEFAULT));
        amper = new JLabel(img);

        imgicon = new ImageIcon("Images/whirl.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(600, 320, Image.SCALE_DEFAULT));
        whirl = new JLabel(img);
        
        imgicon = new ImageIcon("Images/breadboard.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(600, 320, Image.SCALE_DEFAULT));
        breadboard = new JLabel(img);

        chatimg = new ImageIcon("Images/chatimg.png");
        chatbox = new JLabel(chatimg);
        chatfield = new JTextPane();
        styleChatField(chat[chatseq]);

        ms = new MyStyle();
    }

    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(25, 10)));
        frame.add(prevbtn, new Rectangle(0, 9, 3, 1));
        frame.add(nxtbtn, new Rectangle(22, 9, 3, 1));

        frame.add(chatbox, new Rectangle(1, 9, 26, 10));
        frame.add(chatfield, new Rectangle(0, 9, 26, 2));
        frame.add(amper, new Rectangle(5, 4, 3, 5));
        frame.add(breadboard, new Rectangle(16, 3, 5, 4));
        frame.add(whirl, new Rectangle(16, 3, 3, 5));

        chatfield.setBackground(new Color(51, 44, 42));
        whirl.setVisible(false);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        chatfield.setVisible(true);

        addListeners();
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

    public void hideAll() {
        amper.setVisible(false);
        whirl.setVisible(false);
        breadboard.setVisible(false);
    }

    public void addListeners() {
        prevbtn.addMouseListener(this);
        nxtbtn.addMouseListener(this);
    }

    public void setElements() {
        hideAll();
        if (chatseq == 0) {
            breadboard.setVisible(true);
            amper.setVisible(true);
        } else if (chatseq == 1) {
            breadboard.setVisible(true);
            amper.setVisible(true);
            frame.add(amper, new Rectangle(12, 4, 3, 5));
        } else if (chatseq == 2) {
            amper.setVisible(true);
            whirl.setVisible(true);
            breadboard.setVisible(true);
            frame.add(amper, new Rectangle(15,3,3,5));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //click.playEffect("Audio/click.wav");
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
            } else {
                maze1 mm=new maze1();
                Point p=frame.getLocation();
                mm.setFrame();
                mm.frame.setLocation(p);
                frame.dispose();
            }
            setElements();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}


/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class start implements MouseListener{
    JFrame frame;
    
    JLabel nxtbtn;
    JLabel prevbtn;
    
    JTextField chatfield;
    JLabel chatbox;
    int chatseq=0;
    ImageIcon chatimg;
    
    JLabel breadboard;
    JLabel amper;
    
    ImageIcon gameBG;
    ImageIcon img;
    ImageIcon imgicon;
    String chat[];
    
    MyStyle ms;
    
    public start() {
        frame = new JFrame();
        
        
        JPanel backgroundPanel = new JPanel() {
            private final Image gameBG = new ImageIcon("Images/cutscene1.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(gameBG, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel);
    
        
        chat = new String[] {
            "Amper heard an unusual sound in his room...",
            "The breadboard was quivering so he took a step closer.",
            "Suddenly, the breadboard sucked him in!!"
        };
        
        imgicon = new ImageIcon("Images/nxtbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        nxtbtn = new JLabel(img);
        
        imgicon = new ImageIcon("Images/prevbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        prevbtn = new JLabel(img);
        
        imgicon = new ImageIcon("Images/amper.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(740, 450, Image.SCALE_DEFAULT));
        amper = new JLabel(img);
        
        imgicon = new ImageIcon("Images/breadboard.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(600,320, Image.SCALE_DEFAULT));
        breadboard = new JLabel(img);
        
        chatimg = new ImageIcon("Images/chatimg.png");
        chatbox = new JLabel(chatimg);
        chatfield = new JTextField(chat[chatseq]);
        
        ms = new MyStyle();
    }
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (25,10)));
        frame.add(prevbtn, new Rectangle(0,9,3,1));
        frame.add(nxtbtn, new Rectangle(22,9,3,1));
        
        frame.add(chatbox, new Rectangle(1,9,26,10));
        frame.add(chatfield, new Rectangle(0,9,26,2));
        frame.add(amper, new Rectangle(5,4,3,5));
        frame.add(breadboard, new Rectangle(16,3,5,4));
        
        chatfield.setBackground(new Color(51,44,42));

        //chatfield.setAlignmentX(JTextArea.CENTER_ALIGNMENT); 
        //chatfield.setAlignmentY(JTextArea.CENTER_ALIGNMENT); 
        chatfield.setHorizontalAlignment(JTextField.CENTER);
        chatfield.setAlignmentY(JTextField.TOP);
        chatfield.setForeground(Color.WHITE);
        chatfield.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        chatfield.setEditable(false); // Prevent user input
        //chatfield.setLineWrap(true);  // Wrap text
        //chatfield.setWrapStyleWord(true); // Wrap at word boundaries

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        chatfield.setVisible(true);
        
        addListeners();
    }
    
    public void hideAll() {
        amper.setVisible(false);
        breadboard.setVisible(false);
    }
    
    public void addListeners() {
        prevbtn.addMouseListener(this);
        nxtbtn.addMouseListener(this);
    }
    
    public void setElements() {
        hideAll();
        if(chatseq == 0) {
            breadboard.setVisible(true);
            amper.setVisible(true);
        }
        else if(chatseq == 1) {
            breadboard.setVisible(true);
            amper.setVisible(true);
            frame.add(amper, new Rectangle(12,4,3,5));
        }
    }
    
    public static void main(String[] args) {
        start screen = new start();
        screen.setFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==prevbtn) {
            if(chatseq-1>=0){
                chatseq--;
                chatfield.setText(chat[chatseq]);
            }
            setElements();
        }
        else if(e.getSource()==nxtbtn) {
            if(chatseq+1<chat.length) {
                chatseq++;
                chatfield.setText(chat[chatseq]);
            }
            else{
                /*maze1 mm=new maze1();
                Point p=frame.getLocation();
                mm.setFrame();
                mm.frame.setLocation(p);
                frame.dispose();
                newgameBG.clip.stop();*/
            /*}
            setElements();
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
*/