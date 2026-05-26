import javax.swing.*;
import javax.swing.border.LineBorder;
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
        final boolean[] alreadyCatched = {false};
        fish=fishAdded;
        JButton button = new JButton(fishAdded.getImage());
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(150,150));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(1,1,1),1));
        panel.add(button);
        panel.revalidate();
        panel.repaint();


        button.addActionListener(e -> {
            if (!alreadyCatched[0]){
                alreadyCatched[0] =true;
                game.setLastPlus(fishAdded.getValue() + "");
                Icon catched = new ImageIcon(getClass().getResource("catched.png"));
                button.setIcon(catched);
                button.setBorder(new LineBorder(new Color(1,1,1),1));
                if (!fishAdded.isInIndex()){

                    for (Fish fishes : game.getFishCollection()) {
                        if (fishes.equals(fish)) {
                            fishes.setInIndex(true);
                        }
                    }
                }
                game.setScore(game.getScore()+fishAdded.getValue());
                Timer catchedTimer = new Timer(1000,e1 -> {
                    despawnFish();
                    game.setLastPlus(null);
                });
                catchedTimer.setRepeats(false);
                catchedTimer.start();
            }
        });
    }

    public void despawnFish(){
        panel.removeAll();
        panel.revalidate();
        panel.setPreferredSize(new Dimension(150,150));
        panel.repaint();
        fish = null;
    }
}
