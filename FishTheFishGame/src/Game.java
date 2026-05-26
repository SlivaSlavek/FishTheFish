import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private JFrame frame;
    private GameSystem gameSystem;
    private boolean running=true;
    private FishPanel[] fishPlaces = new FishPanel[30];
    ArrayList<Fish>commons=new ArrayList<>();
    ArrayList<Fish>uncommons=new ArrayList<>();
    ArrayList<Fish>rares=new ArrayList<>();
    ArrayList<Fish>epics=new ArrayList<>();
    ArrayList<Fish>legendaries=new ArrayList<>();
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
        for (int i=0;i< fishPlaces.length;i++){
            FishPanel fishPanel=new FishPanel(new JPanel());
            //JPanel fishPanel=new JPanel();
            fishPanel.getPanel().setBackground(new Color(0,0,0,0));
            fishPanel.getPanel().setPreferredSize(new Dimension(150,150));
            //JButton fishButton=new JButton("TEST");
            //fishButton.setBackground(new Color(0,0,0, 0));
            //fishButton.setBorder(new LineBorder(new Color(0,0,0),1));
            //fishButton.setBorderPainted(false);
            //fishButton.setFocusPainted(false);
            //fishPanel.add(fishButton);
            fishPlaces[i]=fishPanel;
            game.add(fishPlaces[i].getPanel());
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


        for (Fish fish : gameSystem.getFishCollection()){
            switch (fish.getRarity()){
                case COMMON -> commons.add(fish);
                case UNCOMMON -> uncommons.add(fish);
                case RARE -> rares.add(fish);
                case EPIC -> epics.add(fish);
                case LEGENDARY -> legendaries.add(fish);
            }
        }


        loop();


    }

    private void loop(){
        Timer gameLoop = new Timer(4000, e -> {
            if (!running){
                ((Timer)e.getSource()).stop();
                return;
            }
            fishSpawner();});
        gameLoop.start();
    }

    private void fishSpawner(){
        Timer spawnTimer=new Timer(randomSecs(1000,5000), e->{
            System.out.println(randomSecs(1,10000));
            spawnFish();
        });
        spawnTimer.setRepeats(false);
        spawnTimer.start();
    }

    private void spawnFish(){
        Random random = new Random();
        if (fishPlaces[random.nextInt(30)].getFish()==null){
            int numm=random.nextInt(51);
            if (numm>=49){

            } else if (numm>44) {
                
            } else if (numm>34) {
                
            } else if (numm>20) {
                
            } else{

            }
        }

    }



    private int randomSecs(int from,int to){
        Random random = new Random();
        return random.nextInt(from,to);
    }
}

