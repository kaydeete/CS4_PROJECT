import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BoothasNiKepler implements KeyListener{
    JFrame frame;
    int map[];
    JLabel tiles[];
    ImageIcon wall;
    ImageIcon monster;
    int currentTile=2;
    
    public BoothasNiKepler(){
        frame=new JFrame();
        monster=new ImageIcon("Images/amper.png");
        wall=new ImageIcon("Images/brickwall.png");
        map=new int[]{
            1,0,2,0,1,1,1,1,1,1,1,1,
            1,0,0,0,0,0,0,0,0,0,1,1,
            1,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,0,0,0,0,1,1,1,0,1,
            1,0,0,0,0,0,0,0,0,0,0,1,
            1,0,0,1,1,1,1,1,0,0,0,1,
            1,0,0,1,0,0,0,0,0,0,0,1,
            1,1,1,1,1,1,1,1,1,1,1,1
        };
        tiles=new JLabel[map.length];
        for(int i=0;i<(12*8);i++){
            if(map[i]==1) tiles[i]=new JLabel(wall);
            else if(map[i]==2) tiles[i]=new JLabel(monster);
            else tiles[i]=new JLabel();
        }
    }
    
    public void setFrame(){
        frame.setLayout(new GraphPaperLayout(new Dimension(12,8)));
        int row=0, col=0;
        for(int i=0;i<(12*8);i++){
            frame.add(tiles[i], new Rectangle(col,row,1,1));
            col++;
            if((i+1)%12==0){
                row++;
                col=0;
            }
        }
        frame.setVisible(true);
        frame.setSize(1280,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addKeyListener(this);
    }
    
    public static void main(String[] args) {
        BoothasNiKepler x=new BoothasNiKepler();
        x.setFrame();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //letters numbers
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_RIGHT){
            if(map[currentTile+1]==0){
                tiles[currentTile].setIcon(null);
                tiles[currentTile+1].setIcon(monster);
                map[currentTile]=0;
                map[currentTile+1]=2;
                currentTile++;
            }
        }
        else if(keycode==KeyEvent.VK_LEFT){
            if(map[currentTile-1]==0){
                tiles[currentTile].setIcon(null);
                tiles[currentTile-1].setIcon(monster);
                map[currentTile]=0;
                map[currentTile-1]=2;
                currentTile--;
            }
        }
        else if(keycode==KeyEvent.VK_DOWN){
            if(map[currentTile+12]==0){
                tiles[currentTile].setIcon(null);
                tiles[currentTile+12].setIcon(monster);
                map[currentTile]=0;
                map[currentTile+12]=2;
                currentTile+=12;
            }
        }
        else if(keycode==KeyEvent.VK_UP){
            if(map[currentTile-12]==0){
                tiles[currentTile].setIcon(null);
                tiles[currentTile-12].setIcon(monster);
                map[currentTile]=0;
                map[currentTile-12]=2;
                currentTile-=12;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
