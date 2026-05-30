import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainMenu {
    private JFrame frame;
    private GameSystem gameSystem;
    public MainMenu(GameSystem gameS) {
        gameSystem=gameS;
        frame=new JFrame("Fish The Fish - Main menu");
        init();
    }
    public void init(){
        ImageIcon logo = new ImageIcon(getClass().getResource("FTF_logo.png"));
        frame.setIconImage(logo.getImage());
        Dimension okraje=new Dimension(70,600);
        frame.setSize(okraje.width*10,okraje.height);
        frame.setPreferredSize(new Dimension(okraje.width*10, okraje.height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(10, 73, 149));

        JLabel background;
        background = new JLabel(new ImageIcon(getClass().getResource("docasnePozadi1.png")));
        background.setLayout(new GridBagLayout());

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(6,1,10,10));
        panel.setBackground(new Color(11, 32, 55,80));
        panel.setPreferredSize(new Dimension(400,500));

        JLabel menuText=new JLabel("       MAIN MENU");
        menuText.setFont(new Font("Comic Sans MS",Font.BOLD,32));
        menuText.setForeground(new Color(192, 205, 255));
        panel.add(menuText);

        JButton buttonPlay=new JButton("PLAY");
        buttonPlay.setSize(okraje.width*4,100);
        buttonPlay.setPreferredSize(new Dimension(okraje.width*4,100));
        buttonPlay.setBackground(new Color(11, 32, 55));
        buttonPlay.setFont(new Font("Comic Sans MS", Font.BOLD,30));
        buttonPlay.setForeground(new Color(171, 184, 230));
        buttonPlay.setBorderPainted(false);
        buttonPlay.setFocusPainted(false);
        panel.add(buttonPlay);
        buttonPlay.addActionListener(e -> {
            new Game(gameSystem);
            frame.dispose();
        });

        JButton buttonFishIndex=new JButton("FISH INDEX");
        buttonFishIndex.setSize(okraje.width*4,100);
        buttonFishIndex.setPreferredSize(new Dimension(okraje.width*4,100));
        buttonFishIndex.setBackground(new Color(11, 32, 55));
        buttonFishIndex.setFont(new Font("Comic Sans MS", Font.BOLD,30));
        buttonFishIndex.setForeground(new Color(171, 184, 230));
        buttonFishIndex.setBorderPainted(false);
        buttonFishIndex.setFocusPainted(false);
        panel.add(buttonFishIndex);
        buttonFishIndex.addActionListener(e -> {
            new Index(gameSystem);
            frame.dispose();
        });

        JButton buttonHelp=new JButton("HELP");
        buttonHelp.setSize(okraje.width*4,100);
        buttonHelp.setPreferredSize(new Dimension(okraje.width*4,100));
        buttonHelp.setBackground(new Color(11, 32, 55));
        buttonHelp.setFont(new Font("Comic Sans MS", Font.BOLD,30));
        buttonHelp.setForeground(new Color(171, 184, 230));
        buttonHelp.setBorderPainted(false);
        buttonHelp.setFocusPainted(false);
        panel.add(buttonHelp);
        buttonHelp.addActionListener(e -> {
            new Help(gameSystem);
            frame.dispose();
        });

        JButton buttonRestart=new JButton("RESTART PROGRESS");
        buttonRestart.setSize(okraje.width*4,100);
        buttonRestart.setPreferredSize(new Dimension(okraje.width*4,100));
        buttonRestart.setBackground(new Color(11, 32, 55));
        buttonRestart.setFont(new Font("Comic Sans MS", Font.BOLD,30));
        buttonRestart.setForeground(new Color(171, 184, 230));
        buttonRestart.setBorderPainted(false);
        buttonRestart.setFocusPainted(false);
        panel.add(buttonRestart);
        buttonRestart.addActionListener(e -> {
            GameSystem gameSystem2 = new GameSystem();
            gameSystem2.init();
            new MainMenu(gameSystem2);
            frame.dispose();
        });


        JButton buttonSaveAQuit=new JButton("SAVE & QUIT");
        buttonSaveAQuit.setSize(okraje.width*4,100);
        buttonSaveAQuit.setPreferredSize(new Dimension(okraje.width*4,100));
        buttonSaveAQuit.setBackground(new Color(11, 32, 55));
        buttonSaveAQuit.setFont(new Font("Comic Sans MS", Font.BOLD,30));
        buttonSaveAQuit.setForeground(new Color(171, 184, 230));
        buttonSaveAQuit.setBorderPainted(false);
        buttonSaveAQuit.setFocusPainted(false);
        panel.add(buttonSaveAQuit);
        buttonSaveAQuit.addActionListener(e -> {



            frame.dispose();
        });


        menuText.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonFishIndex.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonHelp.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonRestart.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonSaveAQuit.setAlignmentX(Component.CENTER_ALIGNMENT);
        background.add(panel);
        frame.add(background);
        frame.pack();
        frame.setVisible(true);
    }
}

