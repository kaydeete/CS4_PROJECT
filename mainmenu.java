/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainmenu implements ActionListener{

    JFrame frame;
    JButton start;
    JButton settings; 
    JButton quit;
    ImageIcon gameBG;
    
    public mainmenu() {
        frame = new JFrame();
        start = new JButton("Start");
        settings = new JButton("Settings");
        quit = new JButton("Quit");
        
        gameBG = new ImageIcon("Images/mainmenuBG.png");
        frame.setContentPane(new JLabel(gameBG));
    }
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension (10,10)));
        
        frame.add(start, new Rectangle (1,1,8,2));
        frame.add(settings, new Rectangle (1,4,8,2));
        frame.add(quit, new Rectangle (1,7,8,2));
        
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        start.addActionListener(this);
        settings.addActionListener(this);
        quit.addActionListener(this);
    }
    
    public static void main(String[] args) {
        mainmenu screen = new mainmenu();
        screen.setFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            frame.dispose();
            start_srn click= new start_srn();
            click.setFrame();
        }
    }
}
