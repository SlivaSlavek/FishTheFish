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

        JTextArea textArea=new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam imperdiet blandit neque non malesuada. Aenean accumsan vel odio id tincidunt. Sed at finibus lorem, in vestibulum neque.Donec tristique sem nec felis tincidunt scelerisque.Sed lacus nulla, venenatis vel erat non, cursus dictum turpis. Nam in augue ac augue commodo malesuada at id eros. Aenean euismod, dui ac mollis scelerisque, neque justo fringilla mi, non pellentesque purus nulla ut nulla. Curabitur a ligula eget eros imperdiet aliquet vel at felis. Proin sed varius lorem. Fusce eu sapien dui. Pellentesque et vulputate augue. Proin vehicula faucibus risus sit amet iaculis. Ut id ultricies odio."+

                "Suspendisse hendrerit aliquam eros.Fusce tristique diam neque, et tristique tellus viverra non. Aliquam auctor, leo at elementum pharetra, orci ex placerat dui, at pretium nulla diam sed sem. Nulla velit neque, porta a malesuada eu, hendrerit non lacus. Mauris id leo risus. Nam in massa convallis, volutpat purus maximus, eleifend nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;" +

                "Proin interdum justo eu ligula malesuada consequat.Sed in metus eros. Nulla malesuada vitae sem non finibus. Sed accumsan facilisis pretium. Nullam vel rhoncus lorem, vitae cursus sem. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc malesuada egestas ante eu varius. In aliquet neque rhoncus velit luctus, non pharetra metus imperdiet. Etiam vel aliquet mi. Ut hendrerit lacus accumsan felis pharetra pharetra. Aenean tincidunt elementum dolor ac dapibus. Phasellus et mauris id neque ullamcorper viverra. Duis mattis id nulla eu pellentesque." +

                "Ut sollicitudin, erat eget euismod efficitur, nunc sapien mattis quam, et aliquet sapien odio id erat. Integer ac nisi erat. Cras gravida ut enim at cursus. In hac habitasse platea dictumst. Phasellus faucibus ante vel mauris varius tempus. Proin vel molestie felis, eu tincidunt mauris. Sed felis dolor, maximus ultricies eros faucibus, laoreet euismod nulla. Sed non tortor aliquam, hendrerit dui eget, maximus nibh. Ut sodales, odio vel ullamcorper ornare, elit justo ornare nibh, non aliquet lectus augue vel dolor. In maximus magna nec ex congue tincidunt. Quisque turpis mi, finibus vel massa a, posuere fermentum mauris." +

                "Vestibulum aliquet, turpis vel scelerisque varius, nibh odio mattis ipsum, id fringilla sapien libero nec eros. Cras elementum, eros in consequat vehicula, sem nisi hendrerit turpis, nec volutpat eros lectus id sapien. Aliquam accumsan ipsum sit amet diam vehicula congue. Pellentesque porta mollis arcu, non dignissim lacus rutrum eu. Vestibulum congue pulvinar pharetra. Nulla facilisi. Aenean tincidunt convallis leo, ac consequat sapien semper ut. Nam vulputate velit eu rhoncus posuere. Vivamus ac iaculis tellus, quis eleifend elit."+

                "Vestibulum pretium ut odio a sodales. Sed eu felis molestie, blandit tellus nec, vulputate purus. Proin laoreet, mauris at condimentum condimentum, lorem nibh tincidunt velit, id sollicitudin dui sapien id lectus. Phasellus dui felis, rutrum tristique faucibus id, aliquet at odio. Nullam aliquam aliquam lobortis. In sed justo non ligula porta aliquet. Fusce feugiat nulla arcu, dictum ornare urna molestie nec. Integer dignissim erat orci. Morbi rhoncus eleifend nisl, et rutrum neque vehicula congue." +

                "In non dui egestas, lacinia ex in, vestibulum ante. Pellentesque fringilla suscipit luctus. Aenean posuere tristique erat vitae lacinia. Suspendisse potenti. Morbi varius vitae nulla et pulvinar. Morbi ac egestas sapien. Vivamus eu finibus diam, volutpat porta dui. Vivamus euismod enim non magna ullamcorper, sit amet hendrerit ligula facilisis. Morbi eu luctus nisl. Donec malesuada sed justo quis elementum. Curabitur congue maximus convallis."+

                "Praesent ac leo justo. Morbi id augue nec orci imperdiet lobortis sed efficitur massa. Duis malesuada ut arcu sed blandit. Sed nulla mauris, eleifend sit amet odio at, blandit luctus nibh. Nam lacus arcu, pulvinar in facilisis non, vehicula non lacus. Nullam auctor in neque porttitor tempus. In dui nisl, euismod nec suscipit id, rhoncus et urna. Fusce libero purus, posuere at tempus sollicitudin, interdum luctus dui."+

                "Vestibulum tincidunt enim sit amet odio semper molestie ut sed libero. Morbi eleifend blandit nisl eget porttitor. Nullam eleifend posuere urna, at condimentum felis. Integer vel viverra tortor, a scelerisque dui. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Curabitur eget elementum orci, nec sodales ipsum. Ut eget ex vestibulum, laoreet sapien nec, scelerisque est. Nam et est ex. Mauris at arcu dapibus, interdum tellus ut, lacinia eros. Proin viverra odio metus, quis condimentum erat ultrices a. Morbi eget pharetra ante. Aenean massa est, dictum in diam sit amet, bibendum iaculis mauris. Fusce dolor dolor, semper ac varius eget, dignissim eget diam." +

                "Nunc molestie ornare neque eget volutpat. Cras vehicula lacus ipsum, eget hendrerit justo molestie sit amet. Nam a lectus nulla. Praesent tempor eu diam vitae scelerisque. Morbi nec efficitur nunc.");

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
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

