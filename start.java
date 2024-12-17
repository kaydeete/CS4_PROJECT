import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class start implements MouseListener{
    JFrame frame;
    
    JLabel nxtbtn;
    JLabel prevbtn;
    JTextArea chatfield;
    JLabel chatbox;
    int chatseq=0;
    ImageIcon chatimg;
    JLabel amper;
    
    ImageIcon gameBG;
    ImageIcon img;
    ImageIcon imgicon;
    String chat[];
    
    MyStyle ms;
    
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
        
        chatimg = new ImageIcon("Images/chatimg.png");
        chatbox = new JLabel(chatimg);
        chatfield = new JTextArea(chat[chatseq]);
        
        ms = new MyStyle();
    }
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (25,10)));
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        addListeners();
    }
    
    public void addListeners() {
        prevbtn.addMouseListener(this);
        nxtbtn.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==prevbtn) {
            if(chatseq-1>=0){
                chatseq--;
                chatfield.setText(chat[chatseq]);
            }
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
}