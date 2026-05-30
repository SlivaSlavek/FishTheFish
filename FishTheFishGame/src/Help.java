import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Help {
    private JFrame frame;
    private GameSystem gameSystem;
    public Help(GameSystem gameS) {
        gameSystem=gameS;
        frame=new JFrame("Fish The Fish - HELP");
        init();
    }
    public void init(){
        ImageIcon logo = new ImageIcon(getClass().getResource("FTF_logo.png"));
        frame.setIconImage(logo.getImage());
        Icon homeLogo = new ImageIcon(getClass().getResource("HomeIcon.png"));
        //Icon homeLogo = new ImageIcon("FishTheFishGame/Resources/HomeIcon.png");
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

        JTextArea textArea=new JTextArea("FISH THE FISH\n How to play?\n\n"+
        " Fishing\n - You can catch fish by clicking on it.\n - Every fish has a value which you get added to your score when you catch it.\n - Sometimes you can fish something bad with negative value so fish carefully!\n\n" +
        " Index \n - In index window you can see which fish you have caught and how many are left as mystery.\n - Index is sorted by rarity.\n\n\n" +
        " About game\n\n" +
        "  Fish The Fish is small game about fishing. You catch various fishes and collect them into you Fish index. You also get score by catching fish, rarer fishes have greater value. \n Game was made by one developer and programmed in Java.\n\n\n" +
        " Credits\n\n" +
        " Programming - Slávek Slíva\n Graphics - Slávek Slíva\n Idea - Slávek Slíva\n Testing - Slávek Slíva and family");

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Comic Sans MS", Font.PLAIN,29));
        textArea.setEditable(false);
        JPanel panel=new JPanel(new BorderLayout());
        JPanel panelRight=new JPanel(new BorderLayout());
        JButton homeButton=new JButton(homeLogo);
        homeButton.setPreferredSize(new Dimension(75,75));
        JScrollPane sp=new JScrollPane(textArea);
        textArea.setBorder(new EmptyBorder(10,10,10,10));
        //sp.add(textArea);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.createVerticalScrollBar();
        panel.add(sp);
        panelRight.add(homeButton,BorderLayout.NORTH);
        panelRight.add(new JLabel(logo), BorderLayout.CENTER);
        panel.add(panelRight,BorderLayout.EAST);
        panel.setPreferredSize(new Dimension(620,510));

        homeButton.addActionListener(e -> {
            new MainMenu(gameSystem);
            frame.dispose();
        });


        background.add(panel);
        frame.add(background);
        frame.pack();
        frame.setVisible(true);
    }
}

