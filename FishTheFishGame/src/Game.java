import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private JFrame frame;
    private GameSystem gameSystem;
    private boolean running=true;
    private FishPanel[] fishPlaces = new FishPanel[30];
    private int pointsNumSize=23;
    private ArrayList<Fish>commons=new ArrayList<>();
    private ArrayList<Fish>uncommons=new ArrayList<>();
    private ArrayList<Fish>rares=new ArrayList<>();
    private ArrayList<Fish>epics=new ArrayList<>();
    private ArrayList<Fish>legendaries=new ArrayList<>();
    private JLabel pointsCount=new JLabel();
    private JLabel pointsPlus=new JLabel("0");
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
            fishPanel.getPanel().setOpaque(false);
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

        if (gameSystem.getScore()>99999){
            pointsNumSize=10;
        }

        JPanel pointsPanel=new JPanel(new GridLayout(5,1));
        pointsPanel.setPreferredSize(new Dimension(75,200));

        JLabel pointsText=new JLabel("Score:");
        pointsText.setFont(new Font("Comic Sans MS",Font.BOLD,23));
        pointsCount.setFont(new Font("Comic Sans MS",Font.PLAIN,pointsNumSize));
        pointsPlus.setFont(new Font("Comic Sans MS",Font.ITALIC,23));


        pointsPanel.add(pointsText);
        pointsPanel.add(pointsCount);
        pointsPanel.add(pointsPlus);



        JButton homeButton=new JButton(homeLogo);
        homeButton.setPreferredSize(new Dimension(75,75));
        homeButton.addActionListener(e -> {
            running=false;
            new MainMenu(gameSystem);
            frame.dispose();
        });
        JPanel panelRight=new JPanel(new BorderLayout());
        panelRight.add(homeButton,BorderLayout.NORTH);
        panelRight.add(pointsPanel, BorderLayout.SOUTH);
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
        Timer gameLoop = new Timer(2000, e -> {
            if (!running){
                ((Timer)e.getSource()).stop();
                return;
            }
            fishSpawner();});
        gameLoop.start();

        Timer uiPlusTimer = new Timer(200, e -> {

            pointsCount.setText(
                    "" + gameSystem.getScore()
            );

            if (gameSystem.getLastPlus() == null){
                pointsPlus.setText("");
            } else {
                pointsPlus.setText(
                        "+" + gameSystem.getLastPlus()
                );
            }

        });

        uiPlusTimer.start();
    }

    private void fishSpawner(){
        Timer spawnTimer=new Timer(randomSecs(1000,5000), e->{
            System.out.println(randomSecs(1,10000));
            //pointsPlus.setText("+" + gameSystem.getLastPlus());
            //pointsCount.setText(""+gameSystem.getScore());
            spawnFish();
        });
        spawnTimer.setRepeats(false);
        spawnTimer.start();
    }

    private void spawnFish(){
        Random random = new Random();
        int which=random.nextInt(30);
        if (fishPlaces[which].getFish()==null){
            System.out.println("vybral se panel " + which);
            int numm=random.nextInt(51);
            if (numm>=49){
                fishPlaces[which].addFish(legendaries.get(random.nextInt(legendaries.size())),gameSystem);
            } else if (numm>44) {
                fishPlaces[which].addFish(epics.get(random.nextInt(epics.size())),gameSystem);
            } else if (numm>34) {
                fishPlaces[which].addFish(rares.get(random.nextInt(rares.size())),gameSystem);
            } else if (numm>20) {
                fishPlaces[which].addFish(uncommons.get(random.nextInt(uncommons.size())),gameSystem);
            } else{
                fishPlaces[which].addFish(commons.get(random.nextInt(commons.size())),gameSystem);
            }
            Timer despawnTimer=new Timer(randomSecs(500,4000),e -> {
               fishPlaces[which].despawnFish();
            });
            despawnTimer.setRepeats(false);
            despawnTimer.start();
        }

    }



    private int randomSecs(int from,int to){
        Random random = new Random();
        return random.nextInt(from,to);
    }
}

