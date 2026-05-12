import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainMenu {
    private JFrame frame;
    public MainMenu() {
        frame=new JFrame("Fish The Fish - Main menu");
        init();
    }
    public void init(){
        Dimension okraje=new Dimension(70,600);
        frame.setSize(okraje.width*10,okraje.height);
        frame.setPreferredSize(new Dimension(okraje.width*10, okraje.height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        frame.setBackground(new Color(10, 73, 149));

        JLabel background;
        try {
            background=new JLabel(new ImageIcon(ImageIO.read(new File("FishTheFishGame/Resources/docasnePozadi1.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        background.setLayout(new GridBagLayout());


        /*
        JPanel panel1=new JPanel();
        panel1.setSize(new Dimension(okraje));
        panel1.setPreferredSize(new Dimension(okraje));
        JPanel panel2=new JPanel();
        panel2.setSize(new Dimension(okraje));
        panel2.setPreferredSize(new Dimension(okraje));
        JPanel panel3=new JPanel();
        panel3.setSize(new Dimension(okraje));
        panel3.setPreferredSize(new Dimension(okraje.height*0+1, okraje.width/2));
        JPanel panel4=new JPanel();
        panel4.setSize(new Dimension(okraje));
        panel4.setPreferredSize(new Dimension(okraje.height*0+1, okraje.width/2));
        panel1.setBackground(new Color(10, 73, 149));
        panel2.setBackground(new Color(10, 73, 149));
        panel3.setBackground(new Color(10, 73, 149));
        panel4.setBackground(new Color(10, 73, 149));

         */


        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(4,1,10,10));
        //panel.setBounds(200,35,okraje.width*4,okraje.height/10*8);
        panel.setBackground(new Color(11, 32, 55,80));

        JLabel menuText=new JLabel("   MAIN MENU");
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
            new Game();
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
            new Index();
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
            new Help();
            frame.dispose();
        });


        //frame.add(panel1, BorderLayout.WEST);
        //frame.add(panel2,BorderLayout.EAST);
        //frame.add(panel3,BorderLayout.NORTH);
        //frame.add(panel4,BorderLayout.SOUTH);

        menuText.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonFishIndex.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonHelp.setAlignmentX(Component.CENTER_ALIGNMENT);
        background.add(panel);
        frame.add(background);
        frame.pack();
        frame.setVisible(true);
    }
}

