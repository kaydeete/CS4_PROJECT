package Quarter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Door3 extends JFrame {
    private JTextField ans1, ans2, ans3a, ans3b, ans4;
    private JButton submitButton;
    private JProgressBar timerBar;
    private int timeLeft = 180; // 3 minutes
    private BackgroundPanel background;
    private Timer timer;

    public Door3() {
        setTitle("Lighting Setup Challenge");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setUndecorated(true);
        setResizable(false);
        
        background = new BackgroundPanel();
        background.setLayout(null);
        setContentPane(background);

        ans1 = createTextField();
        ans2 = createTextField();
        ans3a = createTextField();
        ans3b = createTextField();
        ans4 = createTextField();
        submitButton = new JButton("Submit");

        timerBar = new JProgressBar(0, 180);
        timerBar.setForeground(Color.GREEN);
        timerBar.setBackground(Color.RED);

        background.add(ans1);
        background.add(ans2);
        background.add(ans3a);
        background.add(ans3b);
        background.add(ans4);
        background.add(submitButton);
        background.add(timerBar);

        submitButton.addActionListener(e -> checkAnswers());
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 24));

        startTimer();
        
        setVisible(true);
    }

    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setOpaque(false);
        field.setForeground(Color.BLACK);
        field.setFont(new Font("Segoe UI", Font.BOLD, 22));
        field.setHorizontalAlignment(SwingConstants.CENTER);
        return field;
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                timerBar.setValue(timeLeft);
                if (timeLeft <= 0) {
                    timer.cancel();
                    JOptionPane.showMessageDialog(null, "Time's up!", "Timeout", JOptionPane.WARNING_MESSAGE);
                    dispose();
                }
            }
        }, 0, 1000);
    }

    private void checkAnswers() {
        boolean allCorrect = true;
        StringBuilder wrongFields = new StringBuilder();

        try {
            int a1 = Integer.parseInt(ans1.getText().trim());
            if (a1 != 60) {
                ans1.setBackground(Color.RED);
                wrongFields.append("1. Wrong\n");
                allCorrect = false;
            } else {
                ans1.setBackground(Color.WHITE);
                wrongFields.append("1. Correct\n");
            }
        } catch (Exception e) {
            wrongFields.append("1. Invalid Answer, check formatting\n");
            allCorrect = false;
        }

        try {
            double a2 = Double.parseDouble(ans2.getText().trim());
            if (Math.abs(a2 - 0.2) > 0.01) {
                ans2.setBackground(Color.RED);
                wrongFields.append("2. Wrong\n");
                allCorrect = false;
            } else {
                ans2.setBackground(Color.WHITE);
                wrongFields.append("2. Correct\n");
            }
        } catch (Exception e) {
            wrongFields.append("2. Invalid Answer, check formatting\n");
            allCorrect = false;
        }

        try {
            int a3a = Integer.parseInt(ans3a.getText().trim());
            if (a3a != 80) {
                ans3a.setBackground(Color.RED);
                wrongFields.append("3a. Wrong\n");
                allCorrect = false;
            } else {
                ans3a.setBackground(Color.WHITE);
                wrongFields.append("3a. Correct\n");
                
            }
        } catch (Exception e) {
            wrongFields.append("3a. Invalid Answer, check formatting\n");
            allCorrect = false;
        }
        
        try {
            double a3b = Double.parseDouble(ans3b.getText().trim());
            if (Math.abs(a3b - 0.15) > 0.01) {
                ans3b.setBackground(Color.RED);
                wrongFields.append("3b. Wrong\n");
                allCorrect = false;
            } else {
                ans3b.setBackground(Color.WHITE);
                wrongFields.append("3b. Correct\n");
                
            }
        } catch (Exception e) {
            wrongFields.append("3b. Invalid Answer, check formatting\n");
            allCorrect = false;
        }

        try {
            String a4 = ans4.getText().trim();
            if (!"Yes".equals(a4)) {
                ans4.setBackground(Color.RED);
                wrongFields.append("4. Wrong\n");
                allCorrect = false;
            } else {
                ans4.setBackground(Color.WHITE);
                wrongFields.append("4. Correct\n");
            }
        } catch (Exception e) {
            wrongFields.append("4. Invalid Answer, check formatting\n");
            allCorrect = false;
        }

        if (!allCorrect) {
            JOptionPane.showMessageDialog(this, "Oops! Something went wrong! Check here:\n" + wrongFields.toString(), "Errors", JOptionPane.ERROR_MESSAGE);
        } else {
            if (timer != null) {
            timer.cancel();
            }
            
            new correctans();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Door3();
    }

    // Inner Background Panel Class
    class BackgroundPanel extends JPanel {
        ImageIcon backgroundImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon("Images/d3q.png");
            // Make sure d3q.png is in src/Images/ in NetBeans!
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            Image image = backgroundImage.getImage();
            g.drawImage(image, 0, 0, w, h, this);

            // Dynamically position components based on current size
            if (ans1 != null) {
                ans1.setBounds((int)(w * 0.454), (int)(h * 0.414), (int)(w * 0.13), (int)(h * 0.04));
                ans2.setBounds((int)(w * 0.499), (int)(h * 0.475), (int)(w * 0.13), (int)(h * 0.04));
                ans3a.setBounds((int)(w * 0.639), (int)(h * 0.583), (int)(w * 0.065), (int)(h * 0.04));
                ans3b.setBounds((int)(w * 0.704), (int)(h * 0.583), (int)(w * 0.065), (int)(h * 0.04));
                ans4.setBounds((int)(w * 0.627), (int)(h * 0.698), (int)(w * 0.13), (int)(h * 0.04));
                submitButton.setBounds((int)(w * 0.4), (int)(h * 0.85), (int)(w * 0.2), (int)(h * 0.07));
                timerBar.setBounds(0, h - 30, w, 20);
            }
        }
    }
    
    
 
    class correctans {
        JFrame frame;
        ImageIcon backgroundImage;
        JButton nextButton;
        
        public correctans() {
            frame = new JFrame();
            frame.setSize(900, 600);
            frame.setLayout(new BorderLayout());
            backgroundImage = new ImageIcon("Images/d2correct.png"); /*MAKE NEW CORRECT PAGE PLSPLSPLS, then continue the story nalang plss heheee*/
            
            JPanel backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image image = backgroundImage.getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };
            backgroundPanel.setLayout(new BorderLayout());
        
            nextButton = new JButton("Now, let's escape!");
            nextButton.setBackground(Color.WHITE);
            nextButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
            nextButton.addActionListener(e -> {
            
                maze3 maze = new maze3();
                maze.setFrame();
                frame.dispose();
                
                /*Change this nlng to the next part of the game*/
            });

            backgroundPanel.add(nextButton, BorderLayout.SOUTH);
            frame.setContentPane(backgroundPanel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }    
    }
}