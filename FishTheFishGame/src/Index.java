import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Index {
    private JFrame frame;
    private GameSystem gameSystem;
    public Index(GameSystem gameS) {
        gameSystem=gameS;
        frame=new JFrame("Fish The Fish - Fish index");
        init();
    }
    public void init(){
        int toGet=0;
        Icon homeLogo = new ImageIcon(getClass().getResource("HomeIcon.png"));
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


        JPanel indexPanel=new JPanel();
        indexPanel.setLayout(new BoxLayout(indexPanel,BoxLayout.Y_AXIS));
        for (int i=0;i<gameSystem.getFishCollection().size();i++){
            JPanel fishPanel = new JPanel(new BorderLayout());
            if (gameSystem.getFishCollection().get(i).isInIndex()) {
                fishPanel.setPreferredSize(new Dimension(200, 250));
                JPanel textPanel = new JPanel(new BorderLayout());
                JLabel name = new JLabel(gameSystem.getFishCollection().get(i).getName());
                name.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
                JLabel valueLabel = new JLabel("VALUE: " + gameSystem.getFishCollection().get(i).getValue() + "  (" + gameSystem.getFishCollection().get(i).getRarity() + ")");
                valueLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                textPanel.add(valueLabel, BorderLayout.SOUTH);
                textPanel.add(name, BorderLayout.CENTER);
                textPanel.setBackground(new Color(0, 0, 0, 0));
                fishPanel.add(textPanel, BorderLayout.SOUTH);
                switch (gameSystem.getFishCollection().get(i).getRarity()) {
                    case COMMON -> fishPanel.setBackground(new Color(166, 225, 255));
                    case UNCOMMON -> fishPanel.setBackground(new Color(0, 201, 255));
                    case RARE -> fishPanel.setBackground(new Color(55, 255, 41));
                    case EPIC -> fishPanel.setBackground(new Color(170, 75, 255));
                    case LEGENDARY -> fishPanel.setBackground(new Color(255, 242, 11));
                    case null, default -> fishPanel.setBackground(new Color(89, 89, 89));
                }
                fishPanel.add(new JLabel(gameSystem.getFishCollection().get(i).getImage()), BorderLayout.CENTER);
                indexPanel.add(fishPanel);
            } else{
                fishPanel.setPreferredSize(new Dimension(200, 250));
                JPanel textPanel = new JPanel(new BorderLayout());
                JLabel name = new JLabel("UNKNOWN");
                name.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
                JLabel valueLabel = new JLabel("VALUE: UNKNOWN  (UNKNOWN)");
                valueLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                textPanel.add(valueLabel, BorderLayout.SOUTH);
                textPanel.add(name, BorderLayout.CENTER);
                textPanel.setBackground(new Color(0, 0, 0, 0));
                fishPanel.add(textPanel, BorderLayout.SOUTH);
                fishPanel.add(new JLabel(new ImageIcon(getClass().getResource("UnknownFih.png"))), BorderLayout.CENTER);
                toGet++;
                indexPanel.add(fishPanel);
            }
            fishPanel.setBorder(new LineBorder(new Color(0,0,0),2));


        }


        JPanel panel=new JPanel(new BorderLayout());
        JPanel panelRight=new JPanel(new BorderLayout());
        JButton homeButton=new JButton(homeLogo);
        homeButton.setPreferredSize(new Dimension(75,75));
        JScrollPane sp=new JScrollPane(indexPanel);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(sp);
        panelRight.add(homeButton,BorderLayout.NORTH);
        JLabel foundFromLabel=new JLabel((gameSystem.getFishCollection().size()-toGet)+"/"+gameSystem.getFishCollection().size());
        foundFromLabel.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        panelRight.add(foundFromLabel);
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

