import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game {
    private JFrame frame;
    private GameSystem gameSystem;
    boolean running=true;
    public Game(GameSystem gameS) {
        gameSystem=gameS;
        frame=new JFrame("Fish The Fish");
        init();
    }
    public void init(){
        Dimension okraje=new Dimension(111,825);
        frame.setSize(okraje.width*10,okraje.height);
        frame.setPreferredSize(new Dimension(okraje.width*10, okraje.height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(10, 73, 149));
        Icon homeLogo = new ImageIcon(getClass().getResource("HomeIcon.png"));
        JLabel background=new JLabel();
        background.setBackground(new Color(10, 73, 149));
        background.setLayout(new BorderLayout());
        JLabel game=new JLabel(new ImageIcon(getClass().getResource("GameBackground2.png")));
        game.setLayout(new GridLayout(5,6));
        JPanel[] fishPlaces = new JPanel[30];
        for (int i=0;i< fishPlaces.length;i++){
            JPanel fishPanel=new JPanel();
            fishPanel.setBackground(new Color(0,0,0,0));
            //JButton fishButton=new JButton("TEST");
            //fishButton.setBackground(new Color(0,0,0, 0));
            //fishButton.setBorder(new LineBorder(new Color(0,0,0),1));
            //fishButton.setBorderPainted(false);
            //fishButton.setFocusPainted(false);
            //fishPanel.add(fishButton);
            fishPlaces[i]=fishPanel;
            game.add(fishPlaces[i]);
        }



        JButton homeButton=new JButton(homeLogo);
        homeButton.setPreferredSize(new Dimension(75,75));
        homeButton.addActionListener(e -> {
            running=false;
            new MainMenu(gameSystem);
            frame.dispose();
        });
        JPanel panelRight=new JPanel(new BorderLayout());
        panelRight.add(homeButton,BorderLayout.NORTH);
        background.add(panelRight,BorderLayout.EAST);
        background.add(game);
        frame.add(background);
        frame.pack();
        frame.setVisible(true);


        loop();


    }

    private void loop(){
        Timer gameLoop = new Timer(4000, e -> {
            if (!running){
                ((Timer)e.getSource()).stop();
                return;
            }
            spawnFish();});
        gameLoop.start();
    }

    private void spawnFish(){
        Timer spawnTimer=new Timer(randomSecs(1000,5000), e->{
            System.out.println(randomSecs(1,10000));
        });
        spawnTimer.setRepeats(false);
        spawnTimer.start();
    }



    private int randomSecs(int from,int to){
        Random random = new Random();
        return random.nextInt(from,to);
    }
}

