import javax.swing.*;
import java.awt.*;

public class FishPanel {
    private JPanel panel;
    private Fish fish;

    public FishPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public void addFish(Fish fishAdded, GameSystem game){
        fish=fishAdded;
        JButton button = new JButton(fishAdded.getImage());
        button.setBackground(new Color(0,0,0,0));
        panel.add(button);



        button.addActionListener(e -> {
            Icon catched = new ImageIcon(getClass().getResource("catched.png"));
            button.add(new JLabel(catched));
            if (!fish.isInIndex()){
                for (Fish fishes : game.getFishCollection()) {
                    if (fishes.equals(fish)) {
                        fishes.setInIndex(true);
                    }
                }
            }
            game.setScore(game.getScore()+fishAdded.getValue());
            Timer catchedTimer = new Timer(1000,e1 -> {
                JPanel newPanel = new JPanel();
                newPanel.setBackground(new Color(0,0,0,0));
                newPanel.setPreferredSize(new Dimension(150,150));
                panel=newPanel;
                fish=null;
            });
            catchedTimer.setRepeats(false);
            catchedTimer.start();
        });
    }
}
