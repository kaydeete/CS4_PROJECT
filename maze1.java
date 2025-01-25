import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class maze1 implements MouseListener, KeyListener{
    JFrame frame;
    
    JLabel nxtbtn;
    JLabel prevbtn;
    //JLabel arrow;

    JTextPane chatfield;
    JLabel chatbox;
    int chatseq=0;
    ImageIcon chatimg;
    
    int currentTile;
    JLabel mapL[];
    int map[];

    ImageIcon amper;
    ImageIcon img1; //wall
    ImageIcon img2; //door

    ImageIcon gameBG;
    ImageIcon img;
    ImageIcon imgicon;
    String chat[];

    MyStyle ms;
    PlaySound click;
    PlaySound steps;

    public maze1() {
        frame = new JFrame();
        steps = new PlaySound();
        
        map = new int[]{
            1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,0,0,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,1,
            1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,
            1,0,0,1,1,1,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,1,
            1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,1,1,1,1,
            1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,0,1,
            1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,1,
            1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,1,
            1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,1,
            1,1,1,1,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,0,1,1,1,1,1,1,1,0,0,1,0,0,0,1,
            1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,
            1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,
            1,0,0,1,1,1,1,1,1,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,
            1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1
        };
        currentTile = 1;
        
        imgicon = new ImageIcon("Images/nxtbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        nxtbtn = new JLabel(img);

        imgicon = new ImageIcon("Images/prevbtn.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        prevbtn = new JLabel(img);
        
        /*imgicon = new ImageIcon("Images/arrow.png");
        img = new ImageIcon(imgicon.getImage().getScaledInstance(198, 90, Image.SCALE_DEFAULT));
        arrow = new JLabel(img);*/
        
        chatimg = new ImageIcon("Images/chatimg.png");
        chatbox = new JLabel(chatimg);
        chatfield = new JTextPane();
        
        chat = new String[]{
            "Inside the breadboard is a MAZE",
            "Go to the items and click to find the mystery!"
        };
        
        mapL=new JLabel[map.length];
        imgicon=new ImageIcon("Images/brickwall.png");
        img1=new ImageIcon(imgicon.getImage().getScaledInstance(67, 67, Image.SCALE_DEFAULT));
        imgicon=new ImageIcon("Images/door.png");
        img2=new ImageIcon(imgicon.getImage().getScaledInstance(67, 67, Image.SCALE_DEFAULT));
        imgicon=new ImageIcon("Images/amper.png");
        amper=new ImageIcon(imgicon.getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT));
        for(int i=0;i<map.length;i++){
            if(map[i]==1) mapL[i]=new JLabel(img1);
            else if(map[i]==2) mapL[i]=new JLabel(img2);
            else if(map[i]==3) mapL[i]=new JLabel(amper);
            else mapL[i]=new JLabel();
        }
        
        /*JPanel backgroundPanel = new JPanel() {
            private final Image gameBG = new ImageIcon("Images/maze1scrap.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(gameBG, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel);*/
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(35,19)));
        frame.add(prevbtn, new Rectangle(0, 9, 3, 1));
        frame.add(nxtbtn, new Rectangle(22, 9, 3, 1));
        //frame.add(arrow, new Rectangle(4, 7, 3, 2));
        //arrow.setVisible(false);
        
        int x=0,y=0,w=2,h=2;
        for(int i=0;i<map.length;i++){
            //if(map[i]==1) System.out.println("brick added at "+x+","+y+","+w+","+h);
            frame.add(mapL[i], new Rectangle(x,y,w,h));
            x+=2;
            if((i+1)%12==0){
                x=0;
                y+=2;
            }
        }

        frame.add(chatbox, new Rectangle(1, 9, 26, 10));
        frame.add(chatfield, new Rectangle(0, 9, 26, 2));
        chatfield.setBackground(new Color(51, 44, 42));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        chatfield.setVisible(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
        
        addListeners();
    }
    
    public void addListeners() {
        prevbtn.addMouseListener(this);
        nxtbtn.addMouseListener(this);
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
    
    public boolean checkTile(int n){
        boolean b=false;
        if(map[n]==0) b=true;
        return b;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == prevbtn) {
            if (chatseq - 1 >= 0) {
                chatseq--;
                chatfield.setText(chat[chatseq]);
            }

        } else if (e.getSource() == nxtbtn) {
            if (chatseq + 1 < chat.length) {
                chatseq++;
                chatfield.setText(chat[chatseq]);
                //arrow.setVisible(true);
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

    private void setElements() {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int curr=currentTile;
        if(keyCode==KeyEvent.VK_UP){
            if(checkTile(currentTile-12)) currentTile-=12;
        }
        else if(keyCode==KeyEvent.VK_DOWN){
            if(checkTile(currentTile+12)) currentTile+=12;
        }
        else if(keyCode==KeyEvent.VK_LEFT){
            if(checkTile(currentTile-1)) currentTile-=1;
        }
        else if(keyCode==KeyEvent.VK_RIGHT){
            if(checkTile(currentTile+1)) currentTile+=1;
        }
        
        if(curr!=currentTile){
            map[curr]=0;
            mapL[curr].setIcon(null);
            map[currentTile]=4;
            mapL[currentTile].setIcon(amper);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}