import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Help {
    private JFrame frame;
    public Help() {
        frame=new JFrame("Fish The Fish - HELP");
        init();
    }
    public void init(){
        Dimension okraje=new Dimension(70,600);
        frame.setSize(okraje.width*10,okraje.height);
        frame.setPreferredSize(new Dimension(okraje.width*10, okraje.height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(10, 73, 149));

        JLabel background;
        try {
            background=new JLabel(new ImageIcon(ImageIO.read(new File("FishTheFishGame/Resources/docasnePozadi1.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        background.setLayout(new GridBagLayout());

        JPanel panel=new JPanel(new BorderLayout());
        JPanel panelRight=new JPanel(new BorderLayout());
        JButton homeButton=new JButton("tla4");

        ScrollPane sp=new ScrollPane();
        // ............
        sp.setPreferredSize(new Dimension(600,500));
        panel.add(sp);
        panelRight.add(homeButton,BorderLayout.NORTH);
        panel.add(panelRight,BorderLayout.EAST);
        panel.setPreferredSize(new Dimension(700,600));

        //
        //
        //
        //
        //



        background.add(panel);
        //background.add(homeButton,GridBagConstraints.FIRST_LINE_END);
        //background.add(homeButton);

        frame.add(background);
        frame.pack();
        frame.setVisible(true);
    }
}

