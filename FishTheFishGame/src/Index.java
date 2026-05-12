import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Index {
    private JFrame frame;
    public Index() {
        frame=new JFrame("Fish The Fish - Fish index");
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



        //
        //
        //
        //
        //




        frame.add(background);
        frame.pack();
        frame.setVisible(true);
    }
}

